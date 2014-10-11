package com.coherentlogic.wb.client.core.domain;

import java.io.Serializable;

/**
 * The specification for a bean that has pagination-related properties.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public interface PaginationSpecification extends Serializable {

    public Integer getPage();

    public void setPage(Integer page);

    public Integer getPages();

    public void setPages(Integer pages);

    public Integer getPerPage();

    public void setPerPage(Integer perPage);

    public Integer getTotal();

    public void setTotal(Integer total);
}
