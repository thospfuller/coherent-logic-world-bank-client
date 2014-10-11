package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.WB_SOURCE_NOTE;
import static com.coherentlogic.wb.client.core.domain.Constants.TOPIC_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_TOPIC;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_VALUE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.wb.client.core.converters.TopicConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * A single occurrence of topic-related information -- for example:
 *
 * http://api.worldbank.org/topics
 *
 * Topic only has a value when we call the indicators web service (see also
 * testTopics).
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=TOPIC_TBL)
@XStreamAlias(WB_TOPIC)
@XStreamConverter(value=TopicConverter.class)
public class Topic extends IdValuePair {

    private static final long serialVersionUID = -3862814751332182874L;

    /**
     * The value comes through as an attribute so we override the parent's
     * accessor and mutator methods and declare the property here so that we
     * can apply the appropriate annotation to it.
     */
    @XStreamAlias(WB_VALUE)
    private String value = null;
    
    @XStreamAlias(WB_SOURCE_NOTE)
    private String sourceNote = null;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {

        String oldValue = this.value;

        this.value = value;

        firePropertyChange(VALUE, oldValue, value);
    }

    public String getSourceNote() {
        return sourceNote;
    }

    public void setSourceNote(String sourceNote) {

        String oldValue = this.sourceNote;

        this.sourceNote = sourceNote;

        firePropertyChange(SOURCE_NOTE, oldValue, sourceNote);
    }
}
