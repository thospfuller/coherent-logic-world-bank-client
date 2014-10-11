package com.coherentlogic.wb.client.core.converters;

import com.coherentlogic.wb.client.core.domain.CatalogSources;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 *  A converter that converts wb:sources elements into instances of
 * {@link CatalogSources}.
 *
 * @deprecated This is no longer being used.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CatalogSourcesConverter extends ReflectionConverter {

    public CatalogSourcesConverter(Mapper mapper,
        ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public boolean canConvert(Class type) {
        return CatalogSources.class.isAssignableFrom(type);
    }
}
