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
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INCOME_LEVELS_TBL)
@XStreamAlias(WB_INCOME_LEVELS)
public class IncomeLevels extends PaginationBean {

    private static final long serialVersionUID = 7945626943212138734L;

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
}
