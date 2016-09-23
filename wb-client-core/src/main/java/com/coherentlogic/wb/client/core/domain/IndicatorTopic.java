package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.INDICATOR_TOPIC_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Topic only has a value when we call the indicators web service (see also
 * testTopics).
 *
 * The following query will return a list of wp:indicator objects which are
 * mapped to instances of this class.
 *
 * http://api.worldbank.org/topic/5/indicator
 *
 * @todo Add the SerializableBean type.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=INDICATOR_TOPIC_TBL)
// We need the converter here otherwise XStream won't deserialize the XML
// correctly. This is not exactly a beatiful solution, but it's not brutal
// either.
@XStreamConverter(value=ToAttributedValueConverter.class,
    types={IdentityValueBean.class}, strings={VALUE})
public class IndicatorTopic extends IdentityValueBean {

    private static final long serialVersionUID = 4642154435437990120L;
}
