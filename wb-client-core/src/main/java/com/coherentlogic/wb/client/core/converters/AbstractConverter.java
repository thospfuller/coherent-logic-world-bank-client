package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.exceptions.MethodNotSupportedException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * A converter with a default implementation of the {@link
 * #marshal(Object, HierarchicalStreamWriter, MarshallingContext)} method.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public abstract class AbstractConverter implements Converter {

    /**
     * @throws MethodNotSupportedException This method will not be implemented.
     */
    @Override
    public void marshal(
        Object source,
        HierarchicalStreamWriter writer,
        MarshallingContext context) {
        throw new MethodNotSupportedException(
            "The marshal method is not supported.");
    }
}
