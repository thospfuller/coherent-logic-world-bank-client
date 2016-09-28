package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.Topic;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * A converter that converts wb:topic elements into instances of {@link Topic}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopicConverter extends ReflectionConverter {

    public TopicConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return Topic.class.isAssignableFrom(type);
    }
}
