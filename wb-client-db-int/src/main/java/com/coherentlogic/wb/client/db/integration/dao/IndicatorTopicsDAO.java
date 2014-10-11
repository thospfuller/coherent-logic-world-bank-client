package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.INDICATOR_TOPICS_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.IndicatorTopics;

/**
 * Data access pattern implementation for {@link IndicatorTopics} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=INDICATOR_TOPICS_DAO)
@Transactional
public class IndicatorTopicsDAO extends SerializableDAO<IndicatorTopics> {

    @Override
    public IndicatorTopics find (long primaryKey) {
        return find(IndicatorTopics.class, primaryKey);
    }
}
