package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.*;
import static com.coherentlogic.wb.client.core.domain.Constants.CATALOG_SOURCES_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_SOURCES;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Class represents data returned from a call to the World Bank web services for <i>sources</i> data.
 *
 * @see http://data.worldbank.org/querybuilder -> Data Calls -> Data Sources
 * @see http://api.worldbank.org/sources
 * @see http://api.worldbank.org/source/12?per_page=10
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=CATALOG_SOURCES_TBL)
@XStreamAlias(WB_SOURCES)
// The converter does not have any impact on this class so it has been removed.
//@XStreamConverter(value=CatalogSourcesConverter.class)
public class CatalogSources extends PaginationBean<CatalogSources> {

    private static final long serialVersionUID = -1630994255725531786L;

    @XStreamImplicit
    private List<CatalogSource> sourceList = null;

    @OneToMany(cascade=CascadeType.ALL)
    public List<CatalogSource> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<CatalogSource> sourceList) {

        List<CatalogSource> oldValue = this.sourceList;

        this.sourceList = sourceList;

        firePropertyChange(SOURCE_LIST, oldValue, sourceList);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((sourceList == null) ? 0 : sourceList.hashCode());
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
        CatalogSources other = (CatalogSources) obj;
        if (sourceList == null) {
            if (other.sourceList != null)
                return false;
        } else if (!sourceList.equals(other.sourceList))
            return false;
        return true;
    }
}
