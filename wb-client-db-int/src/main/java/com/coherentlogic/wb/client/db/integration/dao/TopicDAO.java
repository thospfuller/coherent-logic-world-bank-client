package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.TOPIC_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Topic;

/**
 * Data access pattern implementation for {@link Topic} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=TOPIC_DAO)
@Transactional
public class TopicDAO extends SerializableDAO<Topic> {

    @Override
    public Topic find (long primaryKey) {
        return find(Topic.class, primaryKey);
    }
}
