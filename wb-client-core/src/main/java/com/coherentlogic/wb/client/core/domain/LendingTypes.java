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

    private static final long serialVersionUID = 2906188547364937411L;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((lendingTypeList == null) ? 0 : lendingTypeList.hashCode());
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
        LendingTypes other = (LendingTypes) obj;
        if (lendingTypeList == null) {
            if (other.lendingTypeList != null)
                return false;
        } else if (!lendingTypeList.equals(other.lendingTypeList))
            return false;
        return true;
    }
}
