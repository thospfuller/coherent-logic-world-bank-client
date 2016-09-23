package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.INCOME_LEVELS_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INCOME_LEVELS;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INCOME_LEVEL_LIST;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * An aggregation of {@link IncomeLevel} objects -- for example:
 *
 * http://api.worldbank.org/incomeLevels
 *
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INCOME_LEVELS_TBL)
@XStreamAlias(WB_INCOME_LEVELS)
public class IncomeLevels extends PaginationBean<IncomeLevels> {

    private static final long serialVersionUID = 5116005522470843330L;

    @XStreamImplicit
    private List<IncomeLevel> incomeLevelList;

    @OneToMany(cascade=CascadeType.ALL)
    public List<IncomeLevel> getIncomeLevelList() {
        return incomeLevelList;
    }

    public void setIncomeLevelList(List<IncomeLevel> incomeLevelList) {

        List<IncomeLevel> oldValue = this.incomeLevelList;

        this.incomeLevelList = incomeLevelList;

        firePropertyChange(INCOME_LEVEL_LIST, oldValue, incomeLevelList);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((incomeLevelList == null) ? 0 : incomeLevelList.hashCode());
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
        IncomeLevels other = (IncomeLevels) obj;
        if (incomeLevelList == null) {
            if (other.incomeLevelList != null)
                return false;
        } else if (!incomeLevelList.equals(other.incomeLevelList))
            return false;
        return true;
    }
}
