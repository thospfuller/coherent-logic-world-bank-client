package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.*;
import static com.coherentlogic.wb.client.core.domain.Constants.LENDING_TYPES_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_LENDING_TYPES;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Class contains properties that represents a lending type -- for example:
 *
 * http://api.worldbank.org/lendingTypes
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=LENDING_TYPES_TBL)
@XStreamAlias(WB_LENDING_TYPES)
public class LendingTypes extends PaginationBean {

    private static final long serialVersionUID = 3752741599064965541L;

    @XStreamImplicit
    private List<LendingType> lendingTypeList = null;

    @OneToMany(cascade=CascadeType.ALL)
    public List<LendingType> getLendingTypeList() {
        return lendingTypeList;
    }

    public void setLendingTypeList(List<LendingType> lendingTypeList) {

        List<LendingType> oldValue = this.lendingTypeList;

        this.lendingTypeList = lendingTypeList;

        firePropertyChange(LENDING_TYPE_LIST, oldValue, lendingTypeList);
    }
}
