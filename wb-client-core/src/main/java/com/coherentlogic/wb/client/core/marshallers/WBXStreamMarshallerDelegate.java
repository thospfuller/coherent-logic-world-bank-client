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

/**
 * The World Bank API returns XML which differs depending on whether or not the
 * query succeeded or failed. This causes a problem in that the Spring
 * RestTemplate only returns one object and does not have logic to deal with a
 * query which has more than one possible return value.
 * 
 * The solution to deal with this proble is to create a custom marshaller which
 * intercepts the result and if the result is an error, it throws an exception
 * which notifies the user that the query failed.
 * 
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class WBXStreamMarshallerDelegate implements Marshaller, Unmarshaller {

    private final XStreamMarshaller parentMarshaller;

    public WBXStreamMarshallerDelegate(XStreamMarshaller parentMarshaller) {
        super();
        this.parentMarshaller = parentMarshaller;
    }

    @Override
    public Object unmarshal(Source source) throws IOException,
        XmlMappingException {

        Object result = parentMarshaller.unmarshal(source);

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

    // /**
    // * Method checks the result of the call to {@link
    // #unmarshalReader(Reader)}
    // * and throws an exception if this is an instance of {@link ErrorMessage}.
    // */
    // @Override
    // public Object unmarshalReader (Reader reader)
    // throws XmlMappingException, IOException {
    //
    // Object result = super.unmarshalReader (reader);
    //
    // if (result instanceof ErrorMessage) {
    //
    // ErrorMessage error = (ErrorMessage) result;
    //
    // Message message = error.getMessage();
    //
    // throw new InvalidRequestException(message);
    // }
    // return result;
    // }
}
