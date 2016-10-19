package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.COUNTRIES_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Countries;

/**
 * Data access pattern implementation for {@link Countries} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=COUNTRIES_DAO)
@Transactional
public class CountriesDAO extends SerializableDAO<Countries> {

    @Override
    public Countries find (long primaryKey) {
        return find(Countries.class, primaryKey);
    }
}
