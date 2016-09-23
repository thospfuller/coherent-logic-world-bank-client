package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.DATA_POINT_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_COUNTRY;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_DATE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_DECIMAL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INDICATOR;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_VALUE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.COUNTRY;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.DATA_POINT_INDICATOR;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.DATE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.DECIMAL;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.VALUE;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.coherentlogic.wb.client.core.converters.DataPointConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * This class represents a single data point -- for example the following
 * query will return wb:data elements, which are mapped to instances of this
 * class:
 *
 * http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?date=2000:2002
 *
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=DATA_POINT_TBL)
@XStreamConverter(value=DataPointConverter.class)
public class DataPoint extends IdentityValueBean {

    private static final long serialVersionUID = -4415363615093341591L;

    @XStreamAlias(WB_INDICATOR)
//    @OneToOne(cascade = {CascadeType.ALL})
    private DataPointIndicator dataPointIndicator = null;

    @XStreamAlias(WB_COUNTRY)
    private DataPointCountry country = null;

    @XStreamAlias(WB_DATE)
    private String date = null;

    @XStreamAlias(WB_VALUE)
    private String value = null;

    @XStreamAlias(WB_DECIMAL)
    private String decimal = null;

    public DataPoint() {
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public DataPointIndicator getDataPointIndicator() {
        return dataPointIndicator;
    }

    public void setDataPointIndicator(DataPointIndicator dataPointIndicator) {

        DataPointIndicator oldValue = this.dataPointIndicator;

        this.dataPointIndicator = dataPointIndicator;

        firePropertyChange(DATA_POINT_INDICATOR, oldValue, dataPointIndicator);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public DataPointCountry getCountry() {
        return country;
    }

    public void setCountry(DataPointCountry country) {

        DataPointCountry oldValue = this.country;

        this.country = country;

        firePropertyChange(COUNTRY, oldValue, country);
    }

    /**
     * Getter method for the date.
     *
     * Represented as wb:date in the result returned from the World Bank.
     */
    public String getDate() {
        return date;
    }

    /**
     * Date setter method where the date format includes the four-digit year
     * only.
     *
     * @param date For example, "1999".
     */
    public void setDate(String date) {

        String oldValue = this.date;

        this.date = date;

        firePropertyChange(DATE, oldValue, date);
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {

        String oldValue = this.decimal;

        this.decimal = decimal;

        firePropertyChange(DECIMAL, oldValue, decimal);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        String oldValue = this.value;

        this.value = value;

        firePropertyChange(VALUE, oldValue, value);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime
            * result
            + ((dataPointIndicator == null) ? 0 : dataPointIndicator
                .hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((decimal == null) ? 0 : decimal.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        DataPoint other = (DataPoint) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (dataPointIndicator == null) {
            if (other.dataPointIndicator != null)
                return false;
        } else if (!dataPointIndicator.equals(other.dataPointIndicator))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (decimal == null) {
            if (other.decimal != null)
                return false;
        } else if (!decimal.equals(other.decimal))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
