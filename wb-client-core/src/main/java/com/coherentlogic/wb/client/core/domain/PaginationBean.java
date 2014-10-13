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
public class PaginationBean extends SerializableBean
    implements PaginationSpecification {

    private static final long serialVersionUID = 4127798975578870751L;

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

//    @Override
    public Integer getPage() {
        return page;
    }

//    @Override
    public void setPage(Integer page) {

        Integer oldValue = this.page;

        this.page = page;

        firePropertyChange(PropertyConstants.PAGE, oldValue, page);
    }

//    @Override
    public Integer getPages() {
        return pages;
    }

//    @Override
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
}
