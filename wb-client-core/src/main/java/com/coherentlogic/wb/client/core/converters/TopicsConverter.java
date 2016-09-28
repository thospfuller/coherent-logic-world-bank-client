package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.Topics;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * A converter that converts wb:topics elements into instances of {@link Topics}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopicsConverter extends ReflectionConverter {

    public TopicsConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return Topics.class.isAssignableFrom(type);
    }
}
