package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.DataPoint;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 *  A converter that converts wb:data elements into instances of
 * {@link DataPoint}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DataPointConverter extends ReflectionConverter {

    public DataPointConverter(Mapper mapper,
        ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return DataPoint.class.isAssignableFrom(type);
    }
}
