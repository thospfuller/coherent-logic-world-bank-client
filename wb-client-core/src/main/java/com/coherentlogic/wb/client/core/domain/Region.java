package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.REGION_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_REGION;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * A single occurrence of region-related information -- for example:
 *
 * http://api.worldbank.org/countries/br;gb
 *
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=REGION_TBL)
@XStreamAlias(WB_REGION)
//We need the converter here otherwise XStream won't deserialize the XML
//correctly. This is not exactly a beatiful solution, but it's not brutal
//either.
@XStreamConverter(value=ToAttributedValueConverter.class, types={IdentityValueBean.class}, strings={VALUE})
public class Region extends IdentityValueBean {

    private static final long serialVersionUID = -3129188259811188868L;
}
