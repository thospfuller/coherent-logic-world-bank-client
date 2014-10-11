package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.TOPICS_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Topics;

/**
 * Data access pattern implementation for {@link Topics} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=TOPICS_DAO)
@Transactional
public class TopicsDAO extends SerializableDAO<Topics> {

    @Override
    public Topics find (long primaryKey) {
        return find(Topics.class, primaryKey);
    }
}
