package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.CATALOG_SOURCE_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.DESCRIPTION;
import static com.coherentlogic.wb.client.core.domain.Constants.NAME;
import static com.coherentlogic.wb.client.core.domain.Constants.URL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_DESCRIPTION;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_NAME;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_SOURCE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_URL;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * CatalogSource data is not consistently populated across method calls -- ie.
 *
 * http://api.worldbank.org/sources
 *
 * returns a source with an id, name, description, and a url
 *
 * whereas
 *
 * http://api.worldbank.org/indicators/NY.GDP.MKTP.CD
 *
 * returns a source with an id and a value.
 *
 * At the moment we're using this class in both cases however we may change
 * this.
 *
 * @todo URL should be a URL, not a string, however when we're converting this
 *  as a URL an exception is thrown when this is null. We need to sort out if
 *  this can be fixed as it would be ideal to have this data member set to be
 *  the appropriate type.
 *
 * @todo ID should probably be in a parent class.
 * @todo Note that the value is never used so this class should probably only
 *  extend from IdentityObject and not from IdValuePair.
 *
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=CATALOG_SOURCE_TBL)
@XStreamAlias(WB_SOURCE)
public class CatalogSource extends IdentityValueBean {

    private static final long serialVersionUID = -553548971542234579L;

    @XStreamAlias(WB_NAME)
    private String name = null;

    @XStreamAlias(WB_DESCRIPTION)
    private String description = null;

    @XStreamAlias(WB_URL)
    private String url = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        String oldValue = this.name;

        this.name = name;

        firePropertyChange(NAME, oldValue, name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        String oldValue = this.description;

        this.description = description;

        firePropertyChange(DESCRIPTION, oldValue, description);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {

        String oldValue = this.url;

        this.url = url;

        firePropertyChange(URL, oldValue, url);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
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
        CatalogSource other = (CatalogSource) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }
}
