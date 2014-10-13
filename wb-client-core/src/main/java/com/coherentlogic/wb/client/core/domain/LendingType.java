package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.LENDING_TYPE_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_LENDING_TYPE;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * A single occurrence of lending type data -- for example:
 *
 * http://api.worldbank.org/lendingTypes
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=LENDING_TYPE_TBL)
@XStreamAlias(WB_LENDING_TYPE)
//We need the converter here otherwise XStream won't deserialize the XML
//correctly. This is not exactly a beatiful solution, but it's not brutal
//either.
@XStreamConverter(value=ToAttributedValueConverter.class,
 types={IdentityValueBean.class}, strings={VALUE})
public class LendingType extends IdentityValueBean {

    private static final long serialVersionUID = 405434642820412472L;
}
