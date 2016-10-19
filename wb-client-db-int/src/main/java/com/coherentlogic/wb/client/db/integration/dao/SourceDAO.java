package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.SOURCE_DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Source;

/**
 * Data access pattern implementation for {@link Source} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Repository(value=SOURCE_DAO)
@Transactional
public class SourceDAO extends SerializableDAO<Source> {

    @Override
    public Source find (long primaryKey) {
        return find(Source.class, primaryKey);
    }
}
