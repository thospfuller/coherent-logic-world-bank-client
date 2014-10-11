package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.INDICATOR_TOPIC_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.IndicatorTopic;

/**
 * Data access pattern implementation for {@link IndicatorTopic} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=INDICATOR_TOPIC_DAO)
@Transactional
public class IndicatorTopicDAO extends SerializableDAO<IndicatorTopic> {

    @Override
    public IndicatorTopic find (long primaryKey) {
        return find(IndicatorTopic.class, primaryKey);
    }
}
