package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.NAME;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.ADMIN_REGION;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.CAPITAL_CITY;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.COUNTRY_LIST;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INCOME_LEVEL;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.ISO_CODE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.LATITUDE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.LENDING_TYPE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.LONGITUDE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.REGION;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link Country} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CountryTest {

    private final Flag flag = new Flag ();

    private Country country = null;

    @Before
    public void setUp() throws Exception {
        country = new Country ();
    }

    @After
    public void tearDown() throws Exception {
        country = null;
        flag.setValue(false);
    }

    @Test
    public void testSetIsoCode() {
        testSetterMethod (
            country,
            flag,
            ISO_CODE,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setIsoCode(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetName() {
        testSetterMethod (
            country,
            flag,
            NAME,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setName(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetRegion() {

        final Region region = new Region ();

        testSetterMethod (
            country,
            flag,
            REGION,
            null,
            region,
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setRegion(region);
                }
            }
        );
    }

    @Test
    public void testSetAdminRegion() {

        final AdminRegion adminRegion = new AdminRegion();

        testSetterMethod (
            country,
            flag,
            ADMIN_REGION,
            null,
            adminRegion,
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setAdminRegion(adminRegion);
                }
            }
        );
    }

    @Test
    public void testSetIncomeLevel() {

        final IncomeLevel incomeLevel = new IncomeLevel ();

        testSetterMethod (
            country,
            flag,
            INCOME_LEVEL,
            null,
            incomeLevel,
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setIncomeLevel(incomeLevel);
                }
            }
        );
    }

    @Test
    public void testSetLendingType() {

        final LendingType lendingType = new LendingType ();

        testSetterMethod (
            country,
            flag,
            LENDING_TYPE,
            null,
            lendingType,
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setLendingType(lendingType);
                }
            }
        );
    }

    @Test
    public void testSetCapitalCity() {
        testSetterMethod (
            country,
            flag,
            CAPITAL_CITY,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setCapitalCity(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetLongitude() {
        testSetterMethod (
            country,
            flag,
            LONGITUDE,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setLongitude(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetLatitude() {
        testSetterMethod (
            country,
            flag,
            LATITUDE,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<Country> () {
                @Override
                public void execute(Country data) {
                    country.setLatitude(COUNTRY_LIST);
                }
            }
        );
    }
}
