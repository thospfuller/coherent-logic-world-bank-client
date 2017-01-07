package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.domain.CatalogSource;
import com.coherentlogic.wb.client.core.domain.CatalogSources;
import com.coherentlogic.wb.client.core.factories.QueryBuilderFactory;
import com.coherentlogic.wb.client.db.integration.repositories.CatalogSourcesRepository;
import com.coherentlogic.wb.client.db.integration.services.CatalogSourcesService;

/**
 * Unit test for the {@link CatalogSourcesRepository} class.
 *
 * @todo Simplify this test -- see DataPointCountryDAOTest.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
public class CatalogSourcesServiceTest {

    @Autowired
    private CatalogSourcesService catalogSourcesService = null;

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
        catalogSourcesService = null;
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

        catalogSourcesService.save(catalogSources);

        Long uniqueId = catalogSources.getPrimaryKey();

        assertNotNull (uniqueId);

        CatalogSources persistedCatalogSources = catalogSourcesService.findOne(uniqueId);

        List<CatalogSource> persistedCatalogSourceList = persistedCatalogSources.getSourceList();

        assertNotNull (persistedCatalogSources);
        assertEquals (28, persistedCatalogSourceList.size());

        CatalogSource catalogSource = persistedCatalogSourceList.remove(0);

        catalogSource.getPrimaryKey();

        catalogSourcesService.save(persistedCatalogSources);

        CatalogSources mergedCatalogSources = catalogSourcesService.findOne(uniqueId);

        List<CatalogSource> mergedCatalogSourceList = persistedCatalogSources.getSourceList();

        assertEquals (27, mergedCatalogSourceList.size());

        catalogSourcesService.delete(mergedCatalogSources);

        CatalogSources nullCatalogSources = catalogSourcesService.findOne(uniqueId);

        assertNull (nullCatalogSources);
    }
}
