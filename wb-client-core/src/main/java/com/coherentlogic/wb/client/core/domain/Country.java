package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.COUNTRY_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.NAME;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_ADMIN_REGION;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_CAPITAL_CITY;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_COUNTRY;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INCOME_LEVEL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_ISO_CODE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_LATITUDE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_LENDING_TYPE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_LONGITUDE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_NAME;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_REGION;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.ADMIN_REGION;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.CAPITAL_CITY;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INCOME_LEVEL;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.ISO_CODE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.LATITUDE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.LENDING_TYPE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.LONGITUDE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.REGION;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

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
@Table(name=COUNTRY_TBL)
@XStreamAlias(WB_COUNTRY)
public class Country extends IdentityBean {

    private static final long serialVersionUID = -719074263712542778L;

    /**
     * @todo Should this be named iso2Code? This is the value in the XML
     *  response, so the change would make sense.
     */
    @XStreamAlias(WB_ISO_CODE)
    private String isoCode = null;

    @XStreamAlias(WB_NAME)
    private String name = null;

    @XStreamAlias(WB_REGION)
    private Region region = null;

    @XStreamAlias(WB_ADMIN_REGION)
    private AdminRegion adminRegion = null;

    @XStreamAlias(WB_INCOME_LEVEL)
    private IncomeLevel incomeLevel = null;

    @XStreamAlias(WB_LENDING_TYPE)
    private LendingType lendingType = null;

    @XStreamAlias(WB_CAPITAL_CITY)
    private String capitalCity = null;

    @XStreamAlias(WB_LONGITUDE)
    private String longitude = null;

    @XStreamAlias(WB_LATITUDE)
    private String latitude = null;

    /**
     * Method returns the iso code for this country.
     *
     * @todo Empty XML results in "" being returned -- this should probably be
     *  null.
     */
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {

        String oldValue = this.isoCode;

        this.isoCode = isoCode;

        firePropertyChange(ISO_CODE, oldValue, isoCode);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        String oldValue = this.name;

        this.name = name;

        firePropertyChange(NAME, oldValue, name);
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {

        Region oldValue = this.region;

        this.region = region;

        firePropertyChange(REGION, oldValue, region);
    }

    public AdminRegion getAdminRegion() {
        return adminRegion;
    }

    public void setAdminRegion(AdminRegion adminRegion) {

        AdminRegion oldValue = this.adminRegion;

        this.adminRegion = adminRegion;

        firePropertyChange(ADMIN_REGION, oldValue, adminRegion);
    }

    public IncomeLevel getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(IncomeLevel incomeLevel) {

        IncomeLevel oldValue = this.incomeLevel;

        this.incomeLevel = incomeLevel;

        firePropertyChange(INCOME_LEVEL, oldValue, incomeLevel);
    }

    public LendingType getLendingType() {
        return lendingType;
    }

    public void setLendingType(LendingType lendingType) {

        LendingType oldValue = this.lendingType;

        this.lendingType = lendingType;

        firePropertyChange(LENDING_TYPE, oldValue, lendingType);
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {

        String oldValue = this.capitalCity;

        this.capitalCity = capitalCity;

        firePropertyChange(CAPITAL_CITY, oldValue, capitalCity);
    }

    /**
     * Method returns the longitude as a String.
     */
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {

        String oldValue = this.longitude;

        this.longitude = longitude;

        firePropertyChange(LONGITUDE, oldValue, longitude);
    }

    /**
     * Method returns the latitude as a String.
     */
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
    
        String oldValue = this.latitude;

        this.latitude = latitude;

        firePropertyChange(LATITUDE, oldValue, latitude);
    }
}
