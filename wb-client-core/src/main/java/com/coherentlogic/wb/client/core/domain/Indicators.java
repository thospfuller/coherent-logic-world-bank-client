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

    private static final long serialVersionUID = -1865223070921338740L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
			+ ((indicatorList == null) ? 0 : indicatorList.hashCode());
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
		Indicators other = (Indicators) obj;
		if (indicatorList == null) {
			if (other.indicatorList != null)
				return false;
		} else if (!indicatorList.equals(other.indicatorList))
			return false;
		return true;
	}
}
