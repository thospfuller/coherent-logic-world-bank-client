package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.wb.client.core.builders.QueryBuilder;
import com.coherentlogic.wb.client.core.domain.Countries;
import com.coherentlogic.wb.client.core.domain.Country;
import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes;
import com.coherentlogic.wb.client.db.integration.repositories.CountriesRepository;

/**
 * Unit test for the {@link CountriesRepository} class.
 *
 * @todo Simplify this test -- see DataPointCountryDAOTest.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class CountriesServiceTest extends BasicServiceTestHarness<Countries> {

    @Autowired
    private CountriesService countriesService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Override
    protected Countries query(QueryBuilder queryBuilder) {

        Countries countries = queryBuilder
            .countries()
            .setPerPage(10)
            .setIncomeLevel(IncomeLevelCodes.LIC)
            .doGetAsCountries();

        return countries;
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

        countriesService.save(parent);

        Long uniqueId = parent.getPrimaryKey();

        assertNotNull (uniqueId);

        Countries persistedCountries = countriesService.findOne(uniqueId);

        List<Country> persistedCountryList = persistedCountries.getCountryList();

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

        countriesService.save(parent);

        Countries mergedCountries = countriesService.findOne(uniqueId);

        List<Country> mergedCountryList = mergedCountries.getCountryList();

        assertEquals (9, mergedCountryList.size());

        return parent;
    }

    @Override
    protected Countries reviewDeletedParent(Countries parent) {

        Long uniqueId = parent.getPrimaryKey();

        countriesService.delete(parent);

        Countries nullCountries = countriesService.findOne(uniqueId);

        assertNull (nullCountries);

        return parent;
    }
}
