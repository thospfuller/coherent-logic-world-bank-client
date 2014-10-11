package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.Indicator;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * A converter that converts wb:indicator elements into instances of
 * {@link Indicator}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IndicatorConverter extends ReflectionConverter {

    public IndicatorConverter(Mapper mapper,
        ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return Indicator.class.isAssignableFrom(type);
    }
}
