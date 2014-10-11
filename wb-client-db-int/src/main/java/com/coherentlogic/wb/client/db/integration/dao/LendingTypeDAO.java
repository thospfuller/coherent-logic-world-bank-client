package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.LENDING_TYPE_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.LendingType;

/**
 * Data access pattern implementation for {@link LendingType} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=LENDING_TYPE_DAO)
@Transactional
public class LendingTypeDAO extends SerializableDAO<LendingType> {

    @Override
    public LendingType find (long primaryKey) {
        return find(LendingType.class, primaryKey);
    }
}
