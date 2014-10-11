package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INDICATOR_LIST;
import static com.coherentlogic.wb.client.core.domain.Constants.INDICATORS_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INDICATOR;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INDICATORS;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * An aggregation of {@link Indicator} objects.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INDICATORS_TBL)
@XStreamAlias(WB_INDICATORS)
public class Indicators extends PaginationBean {

    private static final long serialVersionUID = -5796028016234532645L;

    @XStreamAlias(WB_INDICATOR)
    @XStreamImplicit
    private List<Indicator> indicatorList;

    @OneToMany(cascade=CascadeType.ALL)
    public List<Indicator> getIndicatorList() {
        return indicatorList;
    }

    public void setIndicatorList(List<Indicator> indicatorList) {

        List<Indicator> oldValue = this.indicatorList;

        this.indicatorList = indicatorList;

        firePropertyChange(INDICATOR_LIST, oldValue, indicatorList);
    }
}
