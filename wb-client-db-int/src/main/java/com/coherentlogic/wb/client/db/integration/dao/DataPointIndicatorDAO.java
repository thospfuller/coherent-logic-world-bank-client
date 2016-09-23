package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.DATA_POINT_INDICATOR_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.DataPointIndicator;

/**
 * Data access pattern implementation for {@link DataPointIndicator} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=DATA_POINT_INDICATOR_DAO)
@Transactional
public class DataPointIndicatorDAO extends SerializableDAO<DataPointIndicator> {

    @Override
    public DataPointIndicator find (long primaryKey) {
        return find(DataPointIndicator.class, primaryKey);
    }
}
