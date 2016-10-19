package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.INCOME_LEVEL_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.IncomeLevel;

/**
 * Data access pattern implementation for {@link IncomeLevel} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=INCOME_LEVEL_DAO)
@Transactional
public class IncomeLevelDAO extends SerializableDAO<IncomeLevel> {

    @Override
    public IncomeLevel find (long primaryKey) {
        return find(IncomeLevel.class, primaryKey);
    }
}
