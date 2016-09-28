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

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=COUNTRY_TBL)
@XStreamAlias(WB_COUNTRY)
public class Country extends IdentityBean {

    private static final long serialVersionUID = -1896842424658297729L;

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

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {

        Region oldValue = this.region;

        this.region = region;

        firePropertyChange(REGION, oldValue, region);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public AdminRegion getAdminRegion() {
        return adminRegion;
    }

    public void setAdminRegion(AdminRegion adminRegion) {

        AdminRegion oldValue = this.adminRegion;

        this.adminRegion = adminRegion;

        firePropertyChange(ADMIN_REGION, oldValue, adminRegion);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public IncomeLevel getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(IncomeLevel incomeLevel) {

        IncomeLevel oldValue = this.incomeLevel;

        this.incomeLevel = incomeLevel;

        firePropertyChange(INCOME_LEVEL, oldValue, incomeLevel);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((adminRegion == null) ? 0 : adminRegion.hashCode());
        result = prime * result
            + ((capitalCity == null) ? 0 : capitalCity.hashCode());
        result = prime * result
            + ((incomeLevel == null) ? 0 : incomeLevel.hashCode());
        result = prime * result + ((isoCode == null) ? 0 : isoCode.hashCode());
        result = prime * result
            + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result
            + ((lendingType == null) ? 0 : lendingType.hashCode());
        result = prime * result
            + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
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
        Country other = (Country) obj;
        if (adminRegion == null) {
            if (other.adminRegion != null)
                return false;
        } else if (!adminRegion.equals(other.adminRegion))
            return false;
        if (capitalCity == null) {
            if (other.capitalCity != null)
                return false;
        } else if (!capitalCity.equals(other.capitalCity))
            return false;
        if (incomeLevel == null) {
            if (other.incomeLevel != null)
                return false;
        } else if (!incomeLevel.equals(other.incomeLevel))
            return false;
        if (isoCode == null) {
            if (other.isoCode != null)
                return false;
        } else if (!isoCode.equals(other.isoCode))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        if (lendingType == null) {
            if (other.lendingType != null)
                return false;
        } else if (!lendingType.equals(other.lendingType))
            return false;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (region == null) {
            if (other.region != null)
                return false;
        } else if (!region.equals(other.region))
            return false;
        return true;
    }
}
