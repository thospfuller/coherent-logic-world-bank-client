package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INDICATOR_TOPIC_LIST;
import static com.coherentlogic.wb.client.core.domain.Constants.INDICATOR_TOPICS_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_TOPIC;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * An aggregation of {@link IndicatorTopic} objects -- for example:
 *
 * http://api.worldbank.org/indicators/NY.GDP.MKTP.CD
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INDICATOR_TOPICS_TBL)
public class IndicatorTopics extends PaginationBean {

    private static final long serialVersionUID = 8942107796954829692L;

    @XStreamAlias(WB_TOPIC)
    @XStreamImplicit
    private List<IndicatorTopic> indicatorTopicList = null;

    @OneToMany(cascade=CascadeType.ALL)
    public List<IndicatorTopic> getIndicatorTopicList() {
        return indicatorTopicList;
    }

    public void setIndicatorTopicList(List<IndicatorTopic> indicatorTopicList) {

        List<IndicatorTopic> oldValue = this.indicatorTopicList;

        this.indicatorTopicList = indicatorTopicList;

        firePropertyChange(INDICATOR_TOPIC_LIST, oldValue, indicatorTopicList);
    }
}
