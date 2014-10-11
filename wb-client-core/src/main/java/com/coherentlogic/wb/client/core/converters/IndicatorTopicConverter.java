package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.IndicatorTopic;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * A converter that converts wb:topic elements into instances of
 * {@link IndicatorTopic}.
 *
 * @deprecated This is no longer being used.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IndicatorTopicConverter extends ReflectionConverter {

    public IndicatorTopicConverter(
        Mapper mapper,
        ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return IndicatorTopic.class.isAssignableFrom(type);
    }
}
