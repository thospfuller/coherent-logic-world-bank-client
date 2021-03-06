package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import com.coherentlogic.wb.client.core.domain.AdminRegion;
import com.coherentlogic.wb.client.core.domain.Countries;
import com.coherentlogic.wb.client.core.domain.Country;
import com.coherentlogic.wb.client.core.domain.IncomeLevel;
import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes;
import com.coherentlogic.wb.client.core.domain.LendingType;
import com.coherentlogic.wb.client.core.domain.Region;
import com.coherentlogic.wb.client.core.factories.QueryBuilderFactory;
import com.coherentlogic.wb.client.db.integration.repositories.CountriesRepository;
import com.coherentlogic.wb.client.db.integration.services.CountriesService;
import com.coherentlogic.wb.client.db.integration.services.CountryService;

/**
 * Unit test for the {@link CountriesRepository} class.
 *
 * @todo Simplify this test -- see DataPointCountryDAOTest.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
public class CountryServiceTest {

    @Autowired
    private CountriesService countriesService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private QueryBuilderFactory queryBuilderFactory = null;

    private Countries countries = null;

    @Before
    public void setUp() throws Exception {

        QueryBuilder queryBuilder = queryBuilderFactory.getInstance();

        countries = queryBuilder
            .countries()
            .setPerPage(10)
            .setIncomeLevel(IncomeLevelCodes.LIC)
            .doGetAsCountries();

        countriesService.save(countries);
    }

    @After
    public void tearDown() throws Exception {
        countriesService = null;
        countryService = null;
        countries = null;
    }

    @Ignore
    @Test
    public void findCountry () {

        List<Country> countryList = countries.getCountryList();

        Country country = countryList.get(2);

        reviewCountry (country);

        Long id = country.getPrimaryKey();

        assertNotNull (id);

        Country persistedCountry = countryService.findOne(id);

        assertNotNull (persistedCountry);
    }

    private void reviewCountry (Country country) {

        assertEquals ("BEN", country.getId());
        assertEquals ("BJ", country.getIsoCode());
        assertEquals ("Benin", country.getName());

        Region region = country.getRegion();

        assertEquals ("SSF", region.getId());
        assertEquals ("Sub-Saharan Africa (all income levels)", region.getValue());

        AdminRegion adminRegion = country.getAdminRegion();

        assertEquals ("SSA", adminRegion.getId());
        assertEquals ("Sub-Saharan Africa (developing only)", adminRegion.getValue());

        IncomeLevel incomeLevel = country.getIncomeLevel();

        assertEquals ("LIC", incomeLevel.getId());
        assertEquals ("Low income", incomeLevel.getValue());

        LendingType lendingType = country.getLendingType();

        assertEquals ("IDX", lendingType.getId());
        assertEquals ("IDA", lendingType.getValue());

        assertEquals ("Porto-Novo", country.getCapitalCity());
        assertEquals ("2.6323", country.getLongitude());
        assertEquals ("6.4779", country.getLatitude());
    }
}
