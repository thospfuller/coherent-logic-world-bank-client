package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.INDICATOR_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_INDICATOR;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_NAME;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_SOURCE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_SOURCE_NOTE;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_SOURCE_ORGANIZATION;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_TOPICS;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INDICATOR_TOPICS;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.NAME;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE_NOTE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE_ORGANIZATION;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityBean;
import com.coherentlogic.wb.client.core.converters.IndicatorConverter;
import com.coherentlogic.wb.client.core.converters.IndicatorTopicsConverter;
import com.coherentlogic.wb.client.core.converters.SourceConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * A representation of World Bank indicator data.
 *
 * @todo Review the need for an XStreamAlias here since we already have the converter assigned.
 *
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INDICATOR_TBL)
@XStreamAlias(WB_INDICATOR)
@XStreamConverter(value=IndicatorConverter.class)
public class Indicator extends IdentityBean {

    private static final long serialVersionUID = -8683623172883423312L;

    @XStreamAlias(WB_NAME)
    private String name = null;

    @XStreamAlias(WB_SOURCE)
    @XStreamConverter(value=SourceConverter.class)
    private Source source = null;

    @XStreamAlias(WB_SOURCE_NOTE)
    private String sourceNote = null;

    @XStreamAlias(WB_SOURCE_ORGANIZATION)
    private String sourceOrganization = null;

    @XStreamAlias(WB_TOPICS)
    @XStreamConverter(value=IndicatorTopicsConverter.class)
    private IndicatorTopics indicatorTopics = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        String oldValue = this.name;

        this.name = name;

        firePropertyChange(NAME, oldValue, name);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {

        Source oldValue = this.source;

        this.source = source;

        firePropertyChange(SOURCE, oldValue, source);
    }

    public String getSourceNote() {
        return sourceNote;
    }

    public void setSourceNote(String sourceNote) {

        String oldValue = this.sourceNote;

        this.sourceNote = sourceNote;

        firePropertyChange(SOURCE_NOTE, oldValue, sourceNote);
    }

    public String getSourceOrganization() {
        return sourceOrganization;
    }

    public void setSourceOrganization(String sourceOrganization) {

        String oldValue = this.sourceOrganization;

        this.sourceOrganization = sourceOrganization;

        firePropertyChange(SOURCE_ORGANIZATION, oldValue, sourceOrganization);
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    public IndicatorTopics getIndicatorTopics() {
        return indicatorTopics;
    }

    public void setIndicatorTopics(IndicatorTopics indicatorTopics) {

        IndicatorTopics oldValue = this.indicatorTopics;

        this.indicatorTopics = indicatorTopics;

        firePropertyChange(INDICATOR_TOPICS, oldValue, indicatorTopics);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
            + ((indicatorTopics == null) ? 0 : indicatorTopics.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((source == null) ? 0 : source.hashCode());
        result = prime * result
            + ((sourceNote == null) ? 0 : sourceNote.hashCode());
        result = prime
            * result
            + ((sourceOrganization == null) ? 0 : sourceOrganization
                .hashCode());
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
        Indicator other = (Indicator) obj;
        if (indicatorTopics == null) {
            if (other.indicatorTopics != null)
                return false;
        } else if (!indicatorTopics.equals(other.indicatorTopics))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (source == null) {
            if (other.source != null)
                return false;
        } else if (!source.equals(other.source))
            return false;
        if (sourceNote == null) {
            if (other.sourceNote != null)
                return false;
        } else if (!sourceNote.equals(other.sourceNote))
            return false;
        if (sourceOrganization == null) {
            if (other.sourceOrganization != null)
                return false;
        } else if (!sourceOrganization.equals(other.sourceOrganization))
            return false;
        return true;
    }
}
