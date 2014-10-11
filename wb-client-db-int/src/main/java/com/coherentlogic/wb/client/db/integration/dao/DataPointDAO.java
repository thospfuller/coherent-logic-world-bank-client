package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.DATA_POINT_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.DataPoint;

/**
 * Data access pattern implementation for {@link DataPoint} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=DATA_POINT_DAO)
@Transactional
public class DataPointDAO extends SerializableDAO<DataPoint> {

    @Override
    public DataPoint find (long primaryKey) {
        return find(DataPoint.class, primaryKey);
    }
}
