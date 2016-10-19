package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.REGION_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Region;

/**
 * Data access pattern implementation for {@link Region} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=REGION_DAO)
@Transactional
public class RegionDAO extends SerializableDAO<Region> {

    @Override
    public Region find (long primaryKey) {
        return find(Region.class, primaryKey);
    }
}
