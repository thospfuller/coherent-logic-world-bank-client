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

import javax.persistence.Entity;
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
 * @todo Review the need for an XStreamAlias here since we already have the
 *  converter assigned.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INDICATOR_TBL)
@XStreamAlias(WB_INDICATOR)
@XStreamConverter(value=IndicatorConverter.class)
public class Indicator extends IdentityBean {

    private static final long serialVersionUID = -3301814083801463308L;

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

    public IndicatorTopics getIndicatorTopics() {
        return indicatorTopics;
    }

    public void setIndicatorTopics(IndicatorTopics indicatorTopics) {

        IndicatorTopics oldValue = this.indicatorTopics;

        this.indicatorTopics = indicatorTopics;

        firePropertyChange(INDICATOR_TOPICS, oldValue, indicatorTopics);
    }
}
