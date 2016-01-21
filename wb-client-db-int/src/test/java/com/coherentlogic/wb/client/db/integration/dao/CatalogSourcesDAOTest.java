package com.coherentlogic.wb.client.db.integration.dao;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.domain.CatalogSource;
import com.coherentlogic.wb.client.core.domain.CatalogSources;
import com.coherentlogic.wb.client.core.factories.QueryBuilderFactory;

/**
 * Unit test for the {@link CatalogSourcesDAO} class.
 *
 * @todo Simplify this test -- see DataPointCountryDAOTest.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"/spring/application-context.xml"})
public class CatalogSourcesDAOTest {

    @Autowired
    private CatalogSourcesDAO catalogSourcesDAO = null;

    @Autowired
    private QueryBuilderFactory queryBuilderFactory = null;

    private CatalogSources catalogSources = null;

    @Before
    public void setUp() throws Exception {
        QueryBuilder builder = queryBuilderFactory.getInstance();

        catalogSources = builder.sources().doGet(CatalogSources.class);
    }

    @After
    public void tearDown() throws Exception {
        catalogSourcesDAO = null;
        catalogSources = null;
    }

    @Ignore
    @Test
    public void reviewCRUDOperations () {

        List<CatalogSource> catalogSourceList = catalogSources.getSourceList();

        assertNotNull (catalogSourceList);
        assertEquals (28, catalogSourceList.size());

        CatalogSource firstCatalogSource = catalogSourceList.get(0);

        assertNull (firstCatalogSource.getPrimaryKey());

        catalogSourcesDAO.persist(catalogSources);

        Long uniqueId = catalogSources.getPrimaryKey();

        assertNotNull (uniqueId);

        CatalogSources persistedCatalogSources =
            catalogSourcesDAO.find(uniqueId);

        List<CatalogSource> persistedCatalogSourceList =
            persistedCatalogSources.getSourceList();

        assertNotNull (persistedCatalogSources);
        assertEquals (28, persistedCatalogSourceList.size());

        CatalogSource catalogSource = persistedCatalogSourceList.remove(0);

        catalogSource.getPrimaryKey();

        catalogSourcesDAO.merge(persistedCatalogSources);

        CatalogSources mergedCatalogSources =
            catalogSourcesDAO.find(uniqueId);

        List<CatalogSource> mergedCatalogSourceList =
            persistedCatalogSources.getSourceList();

        assertEquals (27, mergedCatalogSourceList.size());

        catalogSourcesDAO.remove(mergedCatalogSources);

        CatalogSources nullCatalogSources =
            catalogSourcesDAO.find(uniqueId);

        assertNull (nullCatalogSources);
    }
}
