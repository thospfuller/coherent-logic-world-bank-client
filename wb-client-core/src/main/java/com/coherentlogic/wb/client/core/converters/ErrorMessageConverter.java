package com.coherentlogic.wb.client.core.converters;

import static com.coherentlogic.wb.client.core.domain.Constants.ID;
import static com.coherentlogic.wb.client.core.domain.Constants.KEY;

import com.coherentlogic.wb.client.core.domain.Message;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

/**
 *  A converter that converts wb:message elements into instances of
 * {@link Message}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class ErrorMessageConverter extends IdentityValueBeanConverter {

    public ErrorMessageConverter() {
        super(Message.class);
    }

    @Override
    public Object unmarshal(
        HierarchicalStreamReader reader,
        UnmarshallingContext context
    ) {
        Message message = new Message ();

        String id = reader.getAttribute(ID);

        message.setId(id);

        String key = reader.getAttribute(KEY);

        message.setKey(key);

        String value = reader.getValue();

        message.setValue(value);

        return message;
    }
}
