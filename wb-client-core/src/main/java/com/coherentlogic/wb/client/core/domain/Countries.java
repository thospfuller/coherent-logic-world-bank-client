package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.*;

import static com.coherentlogic.wb.client.core.domain.Constants.COUNTRIES_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_COUNTRIES;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_COUNTRY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Representation of World Bank country data.
 *
 * For example:
 *
 * http://api.worldbank.org/country?per_page=10&region=EMU
 *
 * @see http://data.worldbank.org/country
 * @see http://data.worldbank.org/querybuilder
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=COUNTRIES_TBL)
@XStreamAlias(WB_COUNTRIES)
public class Countries extends PaginationBean {

    private static final long serialVersionUID = -5037715845696551116L;

    @XStreamAlias(WB_COUNTRY)
    @XStreamImplicit
    private List<Country> countryList;

    @OneToMany(cascade=CascadeType.ALL)
    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {

        List<Country> oldValue = this.countryList;

        this.countryList = countryList;

        firePropertyChange(COUNTRY_LIST, oldValue, countryList);
    }
}
