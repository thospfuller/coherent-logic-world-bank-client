package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.CATALOG_SOURCE_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.CatalogSource;

/**
 * Data access pattern implementation for {@link CatalogSource} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=CATALOG_SOURCE_DAO)
@Transactional
public class CatalogSourceDAO extends SerializableDAO<CatalogSource> {

    @Override
    public CatalogSource find (long primaryKey) {
        return find(CatalogSource.class, primaryKey);
    }
}
