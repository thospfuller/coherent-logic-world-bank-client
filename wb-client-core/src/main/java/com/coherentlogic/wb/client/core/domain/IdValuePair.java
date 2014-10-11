package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;

import com.coherentlogic.coherent.data.model.core.domain.IdentityBean;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * Note that children of this class currently need to have an associated
 * converter (IdValuePairConverter) registered, otherwise you'll see null values
 * in the result.
 *
 * @todo We need to consider making the id generic since there is at least one
 *  version of this where the id is a number (see IndicatorSource). Another
 *  solution would be to add a helper method to convert this to a number however
 *  this is less ideal.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IdValuePair extends IdentityBean {

    private static final long serialVersionUID = -5821168050440557783L;

    @XStreamConverter(StringConverter.class)
    private String value = null;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        String oldValue = this.value;

        this.value = value;

        firePropertyChange(VALUE, oldValue, value);
    }
}
