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
public class Countries extends PaginationBean<Countries> {

    private static final long serialVersionUID = 4083267349540633057L;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((countryList == null) ? 0 : countryList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Countries other = (Countries) obj;
        if (countryList == null) {
            if (other.countryList != null)
                return false;
        } else if (!countryList.equals(other.countryList))
            return false;
        return true;
    }
}
