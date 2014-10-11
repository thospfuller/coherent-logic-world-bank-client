package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.INDICATOR_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Indicator;

/**
 * Data access pattern implementation for {@link Indicator} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=INDICATOR_DAO)
@Transactional
public class IndicatorDAO extends SerializableDAO<Indicator> {

    @Override
    public Indicator find (long primaryKey) {
        return find(Indicator.class, primaryKey);
    }
}
