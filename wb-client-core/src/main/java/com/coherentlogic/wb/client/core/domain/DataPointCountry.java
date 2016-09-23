package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.DATA_POINT_COUNTRY_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_COUNTRY;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Class represents a country that is a {@link DataPoint} property.
 *
 * @see {@link DataPoint}
 *
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=DATA_POINT_COUNTRY_TBL)
@XStreamAlias(WB_COUNTRY)
// We need the converter here otherwise XStream won't deserialize the XML
// correctly. This is not exactly a beatiful solution, but it's not brutal
// either.
@XStreamConverter(value=ToAttributedValueConverter.class, types={IdentityValueBean.class}, strings={VALUE})
public class DataPointCountry extends IdentityValueBean {

    private static final long serialVersionUID = 5930232423034113115L;
}
