package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.ADMIN_REGION_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_ADMIN_REGION;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Class represents an administrative region -- for example an administrative region may contain the is "LCN" and the
 * value may be set to "Latin America & Caribbean (all income levels)".
 *
 * @see http://data.worldbank.org/developers/api-overview
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=ADMIN_REGION_TBL)
@XStreamAlias(WB_ADMIN_REGION)
// We need the converter here otherwise XStream won't deserialize the XML correctly. This is not exactly a beautiful
// solution, but it's not brutal either.
@XStreamConverter(value=ToAttributedValueConverter.class, types={IdentityValueBean.class}, strings={VALUE})
public class AdminRegion extends IdentityValueBean {

    private static final long serialVersionUID = -4539675330396358361L;
}
