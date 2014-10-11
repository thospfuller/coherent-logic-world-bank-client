package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.COUNTRIES;
import static com.coherentlogic.wb.client.core.domain.Constants.DESCRIPTION;
import static com.coherentlogic.wb.client.core.domain.Constants.NAME;
import static com.coherentlogic.wb.client.core.domain.Constants.URL;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link CatalogSource} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CatalogSourceTest {

    private final Flag flag = new Flag ();

    private CatalogSource catalogSource = null;

    @Before
    public void setUp() throws Exception {
        catalogSource = new CatalogSource ();
    }

    @After
    public void tearDown() throws Exception {
        catalogSource = null;
        flag.setValue(false);
    }

    @Test
    public void testSetName() {
        testSetterMethod (
            catalogSource,
            flag,
            NAME,
            null,
            COUNTRIES, // Just pick a random string.
            new Action<CatalogSource> () {
                @Override
                public void execute(CatalogSource data) {
                    data.setName(COUNTRIES);
                }
            }
        );
    }

    @Test
    public void testSetDescription() {
    	testSetterMethod (
            catalogSource,
            flag,
            DESCRIPTION,
            null,
            COUNTRIES, // Just pick a random string.
            new Action<CatalogSource> () {
                @Override
                public void execute(CatalogSource data) {
                    data.setDescription(COUNTRIES);
                }
            }
        );
    }

    @Test
    public void testSetUrl() {
    	testSetterMethod (
            catalogSource,
            flag,
            URL,
            null,
            COUNTRIES, // Just pick a random string.
            new Action<CatalogSource> () {
                @Override
                public void execute(CatalogSource data) {
                    data.setUrl(COUNTRIES);
                }
            }
        );
    }
}
