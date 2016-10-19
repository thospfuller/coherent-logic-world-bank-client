package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.INDICATOR_SOURCE_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.IndicatorSource;

/**
 * Data access pattern implementation for {@link IndicatorSource} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=INDICATOR_SOURCE_DAO)
@Transactional
public class IndicatorSourceDAO extends SerializableDAO<IndicatorSource> {

    @Override
    public IndicatorSource find (long primaryKey) {
        return find(IndicatorSource.class, primaryKey);
    }
}
