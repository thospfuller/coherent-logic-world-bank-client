package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.INDICATOR_SOURCE_TBL;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;

/**
 * This class represents a source as it exists as a member of an
 * {@link Indicator}.
 *
 * Note that this is not an ideal solution, though it's not too bad either
 * considering that the World Bank data model has a wb:source element used in
 * several places, however consisting of entirely different set of properties.
 *
 * See the wb:source in the results from this call:
 * 
 * http://api.worldbank.org/indicators/NY.GDP.MKTP.CD
 *
 * <wb:source id="2">World Development Indicators</wb:source>
 *
 * @see {@link Source}
 *
 * @todo This class is empty so we could have all properties persisted at the
 *  IdValuePair level.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INDICATOR_SOURCE_TBL)
public class IndicatorSource extends IdentityValueBean {

    private static final long serialVersionUID = 3905895210852563432L;
}
