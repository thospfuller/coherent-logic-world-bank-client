package com.coherentlogic.wb.client.core.marshallers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.coherentlogic.wb.client.core.domain.Countries;
import com.coherentlogic.wb.client.core.domain.ErrorMessage;
import com.coherentlogic.wb.client.core.domain.Message;
import com.coherentlogic.wb.client.core.exceptions.InvalidRequestException;

/**
 * Unit test for the {@link WBXStreamMarshallerDelegate} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class WBXStreamMarshallerDelegateTest {

    private static final String ID = "the id", KEY = "the key",
        VALUE = "the value";

    private XStreamMarshaller parentMarshaller = null;

    private WBXStreamMarshallerDelegate marshaller = null;

    @Before
    public void setUp() throws Exception {
        parentMarshaller = mock (XStreamMarshaller.class);
        marshaller = new WBXStreamMarshallerDelegate (parentMarshaller);
    }

    @After
    public void tearDown() throws Exception {
        parentMarshaller = null;
        marshaller = null;
    }

    @Test(expected=InvalidRequestException.class)
    public void testUnmarshalExpectingException ()
        throws XmlMappingException, IOException {

        ErrorMessage errorMessage = new ErrorMessage ();

        Message message = new Message ();

        message.setKey(KEY);
//        message.setId(ID);
        message.setValue(VALUE);

        errorMessage.setMessage(message);

        Source source = mock (StreamSource.class);

        when (
            parentMarshaller.unmarshal(source)
        ).thenReturn(errorMessage);

        marshaller.unmarshal(source);
    }

    @Test
    public void testUnmarshalExpectingSuccess ()
        throws XmlMappingException, IOException {

        Countries countries = new Countries ();

        Source source = mock (StreamSource.class);

        when (
            parentMarshaller.unmarshal(source)
        ).thenReturn(countries);

        marshaller.unmarshal(source);
    }
}
