package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.TOPIC_LIST;
import static com.coherentlogic.wb.client.core.domain.Constants.TOPICS_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_TOPICS;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coherentlogic.wb.client.core.converters.TopicsConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * An aggregation of topic objects -- for example:
 *
 * http://api.worldbank.org/topics
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=TOPICS_TBL)
@XStreamAlias(WB_TOPICS)
@XStreamConverter(value=TopicsConverter.class)
public class Topics extends PaginationBean<Topics> {

    private static final long serialVersionUID = -2608272772165645414L;

    @XStreamImplicit
    private List<Topic> topicList = null;

    @OneToMany(cascade=CascadeType.ALL)
    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {

        List<Topic> oldValue = this.topicList;

        this.topicList = topicList;

        firePropertyChange(TOPIC_LIST, oldValue, topicList);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((topicList == null) ? 0 : topicList.hashCode());
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
        Topics other = (Topics) obj;
        if (topicList == null) {
            if (other.topicList != null)
                return false;
        } else if (!topicList.equals(other.topicList))
            return false;
        return true;
    }
}
