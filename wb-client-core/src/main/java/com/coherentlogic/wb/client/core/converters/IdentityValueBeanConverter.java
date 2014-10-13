package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.coherent.data.model.core.converters.AbstractConverter;

/**
 *  A converter that can be extended for the purposes of converting some string
 *  into an instance of a child of {@link IdValuePair}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public abstract class IdentityValueBeanConverter extends AbstractConverter {

    private final Class<?> convertibleClass;

    public IdentityValueBeanConverter(
        Class<?> convertibleClass
    ) {
        this.convertibleClass = convertibleClass;
    }

    @Override
    public boolean canConvert(Class type) {
        return convertibleClass.equals(type);
    }
}
