package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.SOURCE_TBL;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A single source occurrence -- for example:
 *
 * http://api.worldbank.org/topic/5/indicator
 *
 * This only appears on an {@link Indicator} -- for calls to sources and source
 * web services, use a {@link CatalogSource}.
 *
 * @see {@link CatalogSource} for use with http://api.worldbank.org/sources.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=SOURCE_TBL)
public class Source extends IdValuePair {

    private static final long serialVersionUID = 9198649338192873361L;

}
