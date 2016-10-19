package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.DATA_POINT_COUNTRY_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.DataPointCountry;

/**
 * Data access pattern implementation for {@link DataPointCountry} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=DATA_POINT_COUNTRY_DAO)
@Transactional
public class DataPointCountryDAO extends SerializableDAO<DataPointCountry> {

    @Override
    public DataPointCountry find (long primaryKey) {
        return find(DataPointCountry.class, primaryKey);
    }
}
