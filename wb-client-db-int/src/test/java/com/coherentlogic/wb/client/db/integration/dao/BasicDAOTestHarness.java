package com.coherentlogic.wb.client.db.integration.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.coherent.data.adapter.core.db.integration.dao.SerializableDAO;
import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.factories.QueryBuilderFactory;

/**
 * Unit test for the {@link CatalogSourcesDAO} class.
 *
 * @param P the parent object.
 * @param C the children; note that this is optional as not all domain objects
 *  will have children.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
public abstract class BasicDAOTestHarness<P extends SerializableBean, C> {

    @Autowired
    private QueryBuilderFactory queryBuilderFactory = null;

    protected abstract P query (QueryBuilder queryBuilder);

    protected abstract P reviewNonPersistedObject (P parent);

    protected abstract P reviewPersistedObject (P parent);

    protected abstract P removeChildren (P parent);

    protected abstract P reviewMergedObject (P parent);

    protected abstract P reviewDeletedParent (P parent);

    @Test
    public abstract void reviewCRUDOperations ();

    public void reviewCRUDOperations (SerializableDAO<P> defaultDAO) {

        QueryBuilder queryBuilder = queryBuilderFactory.getInstance();

        P parent = query (queryBuilder);

        if (parent == null)
            fail("The resultant parent is null and this should never happen.");

        P result = reviewNonPersistedObject (parent);

        result = reviewPersistedObject (result);

        result = removeChildren (result);

        result = reviewMergedObject (result);

        result = reviewDeletedParent(result);
    }
}
