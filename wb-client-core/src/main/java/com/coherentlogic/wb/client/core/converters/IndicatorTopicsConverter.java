package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.IndicatorTopics;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * A converter that converts wb:topics elements into instances of {@link IndicatorTopics}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IndicatorTopicsConverter extends ReflectionConverter {

    public IndicatorTopicsConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return IndicatorTopics.class.isAssignableFrom(type);
    }
}
