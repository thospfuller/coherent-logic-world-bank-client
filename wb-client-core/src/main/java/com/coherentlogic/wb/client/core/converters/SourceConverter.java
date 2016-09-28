package com.coherentlogic.wb.client.core.converters;

import static com.coherentlogic.wb.client.core.domain.Constants.ID;

import com.coherentlogic.wb.client.core.domain.Source;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

/**
 * A converter that converts wb:source elements into instances of {@link Source}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SourceConverter extends IdentityValueBeanConverter {

    public SourceConverter() {
        super(Source.class);
    }

    @Override
    public Object unmarshal(
        HierarchicalStreamReader reader,
        UnmarshallingContext context
    ) {
        Source source = new Source ();

        String id = reader.getAttribute(ID);

        source.setId(id);

        String value = reader.getValue();

        source.setValue(value);

        return source;
    }
}
