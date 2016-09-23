package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.COUNTRY_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Country;

/**
 * Data access pattern implementation for {@link Country} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=COUNTRY_DAO)
@Transactional
public class CountryDAO extends SerializableDAO<Country> {

    @Override
    public Country find (long primaryKey) {
        return find(Country.class, primaryKey);
    }
}
