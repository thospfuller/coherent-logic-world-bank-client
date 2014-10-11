package com.coherentlogic.wb.client.db.integration.dao;

import static com.coherentlogic.wb.client.db.integration.dao.DAOConstants.INDICATORS_DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.model.db.integration.dao.SerializableDAO;
import com.coherentlogic.wb.client.core.domain.Indicators;

/**
 * Data access pattern implementation for {@link Indicators} objects.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@Component(value=INDICATORS_DAO)
@Transactional
public class IndicatorsDAO extends SerializableDAO<Indicators> {

    @Override
    public Indicators find (long primaryKey) {
        return find(Indicators.class, primaryKey);
    }
}
