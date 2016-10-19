package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.DATA_POINTS_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.DataPoints;

/**
 * Data access pattern implementation for {@link DataPoints} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=DATA_POINTS_DAO)
@Transactional
public class DataPointsDAO extends SerializableDAO<DataPoints> {

    @Override
    public DataPoints find (long primaryKey) {
        return find(DataPoints.class, primaryKey);
    }
}
