package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.CATALOG_SOURCES_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.CatalogSources;

/**
 * Data access pattern implementation for {@link CatalogSources} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=CATALOG_SOURCES_DAO)
@Transactional
public class CatalogSourcesDAO extends SerializableDAO<CatalogSources> {

    @Override
    public CatalogSources find (long primaryKey) {
        return find(CatalogSources.class, primaryKey);
    }
}
