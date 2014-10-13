package com.coherentlogic.wb.client.core.converters;

import static com.coherentlogic.wb.client.core.domain.Constants.ID;

import com.coherentlogic.wb.client.core.domain.DataPointIndicator;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

/**
 * A converter that converts wb:data elements into instances of
 * {@link DataPointIndicator}.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DataPointIndicatorConverter extends IdentityValueBeanConverter {

    public DataPointIndicatorConverter() {
        super(DataPointIndicator.class);
    }

    public Object unmarshal(
        HierarchicalStreamReader reader,
        UnmarshallingContext context
    ) {
        DataPointIndicator dataPointIndicator = new DataPointIndicator ();

        String id = reader.getAttribute(ID);

        dataPointIndicator.setId(id);

        String value = reader.getValue();

        dataPointIndicator.setValue(value);

        return dataPointIndicator;
    }

    @Override
    public boolean canConvert(Class type) {
        return false;
    }
}
