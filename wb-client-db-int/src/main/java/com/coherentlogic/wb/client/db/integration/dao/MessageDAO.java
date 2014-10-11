package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.MESSAGE_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Message;

/**
 * Data access pattern implementation for {@link Message} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=MESSAGE_DAO)
@Transactional
public class MessageDAO extends SerializableDAO<Message> {

    @Override
    public Message find (long primaryKey) {
        return find(Message.class, primaryKey);
    }
}
