package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.DATA_POINT_INDICATOR_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INDICATOR;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * A representation of an indicator, which is an element in a data point.
 *
 * Note that there is an {@link Indicator} which is used elsewhere in this API,
 * however the properties in this class are more numerous, hence we cannot use
 * that as a DataPoint property.
 *
 * @see {@link DataPoint}
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=DATA_POINT_INDICATOR_TBL)
@XStreamAlias(WB_INDICATOR)
@XStreamConverter(value=ToAttributedValueConverter.class,
    types={IdentityValueBean.class}, strings={VALUE})
public class DataPointIndicator extends IdentityValueBean {

    private static final long serialVersionUID = -8077529068703406981L;

    public DataPointIndicator() {
    }
}
