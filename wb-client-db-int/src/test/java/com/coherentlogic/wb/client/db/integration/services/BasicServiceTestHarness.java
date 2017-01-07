package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.factories.QueryBuilderFactory;
import com.coherentlogic.wb.client.db.integration.repositories.CatalogSourcesRepository;

/**
 * Unit test for the {@link CatalogSourcesRepository} class.
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
public abstract class BasicServiceTestHarness<P> {

    @Autowired
    private QueryBuilderFactory queryBuilderFactory = null;

    protected abstract P query (QueryBuilder queryBuilder);

    protected abstract P reviewNonPersistedObject (P parent);

    protected abstract P reviewPersistedObject (P parent);

    protected abstract P removeChildren (P parent);

    protected abstract P reviewMergedObject (P parent);

    protected abstract P reviewDeletedParent (P parent);

    @Test
    public void reviewCRUDOperations () {

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
