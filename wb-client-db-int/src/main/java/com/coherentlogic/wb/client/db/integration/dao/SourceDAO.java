package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.SOURCE_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Source;

/**
 * Data access pattern implementation for {@link Source} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=SOURCE_DAO)
@Transactional
public class SourceDAO extends SerializableDAO<Source> {

    @Override
    public Source find (long primaryKey) {
        return find(Source.class, primaryKey);
    }
}
