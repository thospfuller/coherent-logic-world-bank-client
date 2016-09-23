package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.PAGE;
import static com.coherentlogic.wb.client.core.domain.Constants.PAGES;
import static com.coherentlogic.wb.client.core.domain.Constants.PER_PAGE;
import static com.coherentlogic.wb.client.core.domain.Constants.TOTAL;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * A bean that has pagination-related properties.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class PaginationBean<T> extends SerializableBean<T> implements PaginationSpecification {

    private static final long serialVersionUID = 5178764963047504945L;

    @XStreamAlias(PAGE)
    @XStreamAsAttribute
    private Integer page = null;

    @XStreamAlias(PAGES)
    @XStreamAsAttribute
    private Integer pages = null;

    @XStreamAlias(PER_PAGE)
    @XStreamAsAttribute
    private Integer perPage  = null;

    @XStreamAlias(TOTAL)
    @XStreamAsAttribute
    private Integer total = null;

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public void setPage(Integer page) {

        Integer oldValue = this.page;

        this.page = page;

        firePropertyChange(PropertyConstants.PAGE, oldValue, page);
    }

    @Override
    public Integer getPages() {
        return pages;
    }

    @Override
    public void setPages(Integer pages) {

        Integer oldValue = this.pages;

        this.pages = pages;

        firePropertyChange(PropertyConstants.PAGES, oldValue, pages);
    }

    @Override
    public Integer getPerPage() {
        return perPage;
    }

    @Override
    public void setPerPage(Integer perPage) {

        Integer oldValue = this.perPage;

        this.perPage = perPage;

        firePropertyChange(PropertyConstants.PER_PAGE, oldValue, perPage);
    }

    @Override
    public Integer getTotal() {
        return total;
    }

    @Override
    public void setTotal(Integer total) {

        Integer oldValue = this.total;
        
        this.total = total;

        firePropertyChange(PropertyConstants.TOTAL, oldValue, total);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((page == null) ? 0 : page.hashCode());
        result = prime * result + ((pages == null) ? 0 : pages.hashCode());
        result = prime * result + ((perPage == null) ? 0 : perPage.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
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
        PaginationBean other = (PaginationBean) obj;
        if (page == null) {
            if (other.page != null)
                return false;
        } else if (!page.equals(other.page))
            return false;
        if (pages == null) {
            if (other.pages != null)
                return false;
        } else if (!pages.equals(other.pages))
            return false;
        if (perPage == null) {
            if (other.perPage != null)
                return false;
        } else if (!perPage.equals(other.perPage))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        return true;
    }
}
