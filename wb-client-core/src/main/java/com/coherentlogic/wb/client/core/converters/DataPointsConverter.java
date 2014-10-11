package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.DataPoints;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 *  A converter that converts wb:data elements into instances of
 * {@link DataPoints}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DataPointsConverter extends ReflectionConverter {

    public DataPointsConverter(Mapper mapper,
        ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return DataPoints.class.isAssignableFrom(type);
    }

//    @Override
//    public Object unmarshal(
//        HierarchicalStreamReader reader,
//        UnmarshallingContext context
//    ) {
//        Object obj = super.unmarshal(reader, context);
//
//        return obj;
//    }
}
