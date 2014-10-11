package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.DATA_POINTS_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.DataPoints;

/**
 * Data access pattern implementation for {@link DataPoints} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=DATA_POINTS_DAO)
@Transactional
public class DataPointsDAO extends SerializableDAO<DataPoints> {

    @Override
    public DataPoints find (long primaryKey) {
        return find(DataPoints.class, primaryKey);
    }
}
