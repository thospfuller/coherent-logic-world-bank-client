package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.domain.Countries;
import com.coherentlogic.wb.client.core.domain.Country;
import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes;
import com.coherentlogic.wb.client.db.integration.repositories.CountriesRepository;
import com.coherentlogic.wb.client.db.integration.services.CountriesService;

/**
 * Unit test for the {@link CountriesRepository} class.
 *
 * @todo Simplify this test -- see DataPointCountryDAOTest.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Ignore
public class CountriesDAOTest extends BasicDAOTestHarness<Countries> {

    @Autowired
    private CountriesService countriesDAO;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Override
    protected Countries query(QueryBuilder queryBuilder) {
        return queryBuilder
            .countries()
            .setPerPage(10)
            .setIncomeLevel(IncomeLevelCodes.LIC)
            .doGet(Countries.class);
    }

    @Override
    protected Countries reviewNonPersistedObject(Countries parent) {

        List<Country> countryList = parent.getCountryList();

        assertNotNull (countryList);
        assertEquals (10, countryList.size ());

        Country firstCountry = countryList.get(0);

        assertNull (firstCountry.getPrimaryKey());

        return parent;
    }

    @Override
    protected Countries reviewPersistedObject(Countries parent) {
        countriesDAO.save(parent);

        Long uniqueId = parent.getPrimaryKey();

        assertNotNull (uniqueId);

        Countries persistedCountries =
            countriesDAO.findOne(uniqueId);

        List<Country> persistedCountryList =
                persistedCountries.getCountryList();

        assertNotNull (persistedCountryList);
        assertEquals (10, persistedCountryList.size());

        return parent;
    }

    @Override
    protected Countries removeChildren(Countries parent) {

        List<Country> countryList = parent.getCountryList();

        countryList.remove(0);

        return parent;
    }

    @Override
    protected Countries reviewMergedObject(Countries parent) {

        Long uniqueId = parent.getPrimaryKey();

        countriesDAO.save(parent);

        Countries mergedCountries =
            countriesDAO.findOne(uniqueId);

        List<Country> mergedCountryList =
            mergedCountries.getCountryList();

        assertEquals (9, mergedCountryList.size());

        return parent;
    }

    @Override
    protected Countries reviewDeletedParent(Countries parent) {

        Long uniqueId = parent.getPrimaryKey();

        countriesDAO.delete(parent);

        Countries nullCountries =
            countriesDAO.findOne(uniqueId);

        assertNull (nullCountries);

        return parent;
    }
}
