package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.ADMIN_REGION_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.AdminRegion;

/**
 * Data access pattern implementation for {@link AdminRegion} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=ADMIN_REGION_DAO)
@Transactional
public class AdminRegionDAO extends SerializableDAO<AdminRegion> {

    @Override
    public AdminRegion find (long primaryKey) {
        return find(AdminRegion.class, primaryKey);
    }
}
