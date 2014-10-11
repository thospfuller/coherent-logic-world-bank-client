package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.COUNTRY_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link Countries} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CountriesTest {

    private final Flag flag = new Flag ();

    private Countries country = null;

    @Before
    public void setUp() throws Exception {
        country = new Countries ();
    }

    @After
    public void tearDown() throws Exception {
        country = null;
        flag.setValue(false);
    }

    @Test
    public void testSetSourceList() {

        final List<Country> catalogSourceList =
            new ArrayList<Country> ();

        testSetterMethod (
            country,
            flag,
            COUNTRY_LIST,
            null,
            catalogSourceList,
            new Action<Countries> () {
                @Override
                public void execute(Countries data) {
                    country.setCountryList(catalogSourceList);
                }
            }
        );
    }
}
