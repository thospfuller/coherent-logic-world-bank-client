package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.INCOME_LEVELS_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.IncomeLevels;

/**
 * Data access pattern implementation for {@link IncomeLevels} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=INCOME_LEVELS_DAO)
@Transactional
public class IncomeLevelsDAO extends SerializableDAO<IncomeLevels> {

    @Override
    public IncomeLevels find (long primaryKey) {
        return find(IncomeLevels.class, primaryKey);
    }
}
