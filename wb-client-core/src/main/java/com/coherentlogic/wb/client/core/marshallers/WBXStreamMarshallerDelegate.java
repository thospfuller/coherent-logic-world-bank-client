package com.coherentlogic.wb.client.core.marshallers;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.coherentlogic.wb.client.core.domain.ErrorMessage;
import com.coherentlogic.wb.client.core.domain.Message;
import com.coherentlogic.wb.client.core.exceptions.InvalidRequestException;
import com.coherentlogic.wb.client.core.exceptions.InvalidResponseReceivedException;
import com.thoughtworks.xstream.io.StreamException;

/**
 * The World Bank API returns XML which differs depending on whether or not the
 * query succeeded or failed. This causes a problem in that the Spring
 * RestTemplate only returns one object and does not have logic to deal with a
 * query which has more than one possible return value.
 * 
 * The solution to deal with this problem is to create a custom marshaller which
 * intercepts the result and if the result is an error, it throws an exception
 * which notifies the user that the query failed.
 * 
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class WBXStreamMarshallerDelegate implements Marshaller, Unmarshaller {

    private static final String INVALID_XML_MSG = "The World Bank appears to "
        + "have returned some invalid XML -- see the cause for more details "
        + "and note that this has been going on for some time now and seems "
        + "to change from one method to the next at seemingly random "
        + "intervals. The problem is that the byte order mark (BOM -- see here "
        + "http://en.wikipedia.org/wiki/Byte_order_mark#UTF-8) for UTF-8 "
        + "encoded text contains an invalid character.";

    private final XStreamMarshaller parentMarshaller;

    public WBXStreamMarshallerDelegate(XStreamMarshaller parentMarshaller) {
        super();
        this.parentMarshaller = parentMarshaller;
    }

    @Override
    public Object unmarshal(Source source) throws IOException,
        XmlMappingException {

        Object result = null;

        try {
            result = parentMarshaller.unmarshal(source);
        } catch (StreamException streamException) {
            String text = streamException.getMessage();
            // May need to change the contains if we switch the driver from an
            // XppDriver to something else as the message that is returned will
            // likely be different.
            if (
                text != null
                &&
                text.contains (
                    "only whitespace content allowed before start tag and not"
                )
            ) {
                throw new InvalidResponseReceivedException(INVALID_XML_MSG,
                    streamException);
            }
        }

        if (result instanceof ErrorMessage) {

            ErrorMessage errorMessage = (ErrorMessage) result;

            Message message = errorMessage.getMessage();

            throw new InvalidRequestException(message);
        }
        return result;
    }

    @Override
    public boolean supports(Class<?> clazz) {

        boolean result = parentMarshaller.supports(clazz);

        return result;
    }

    @Override
    public void marshal(Object graph, Result result) throws IOException,
        XmlMappingException {
        parentMarshaller.marshal(graph, result);
    }
}
