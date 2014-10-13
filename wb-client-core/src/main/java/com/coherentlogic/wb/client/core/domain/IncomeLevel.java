package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.INCOME_LEVEL_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INCOME_LEVEL;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * A single income level entry -- for example:
 * 
 * http://api.worldbank.org/incomeLevels
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INCOME_LEVEL_TBL)
@XStreamAlias(WB_INCOME_LEVEL)
// We need the converter here otherwise XStream won't deserialize the XML
// correctly. This is not exactly a beautiful solution, but it's not brutal
// either.
@XStreamConverter(value=ToAttributedValueConverter.class,
    types={IdentityValueBean.class}, strings={VALUE})
public class IncomeLevel extends IdentityValueBean {

    private static final long serialVersionUID = -8487721255922835678L;

}
