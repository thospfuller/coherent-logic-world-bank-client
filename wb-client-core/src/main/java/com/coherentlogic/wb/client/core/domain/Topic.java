package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.TOPIC_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_SOURCE_NOTE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_TOPIC;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_VALUE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE_NOTE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.VALUE;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
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
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=TOPIC_TBL)
@XStreamAlias(WB_TOPIC)
@XStreamConverter(value=TopicConverter.class)
public class Topic extends IdentityValueBean {

    private static final long serialVersionUID = -3187439709310925507L;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((sourceNote == null) ? 0 : sourceNote.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        Topic other = (Topic) obj;
        if (sourceNote == null) {
            if (other.sourceNote != null)
                return false;
        } else if (!sourceNote.equals(other.sourceNote))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
