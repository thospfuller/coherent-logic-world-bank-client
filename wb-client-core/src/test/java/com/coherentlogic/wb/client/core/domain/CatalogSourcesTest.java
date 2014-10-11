package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link CatalogSources} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CatalogSourcesTest {

    private final Flag flag = new Flag ();

    private CatalogSources catalogSources = null;

    @Before
    public void setUp() throws Exception {
        catalogSources = new CatalogSources ();
    }

    @After
    public void tearDown() throws Exception {
        catalogSources = null;
        flag.setValue(false);
    }

    @Test
    public void testSetSourceList() {

        final List<CatalogSource> catalogSourceList =
            new ArrayList<CatalogSource> ();

        testSetterMethod (
            catalogSources,
            flag,
            SOURCE_LIST,
            null,
            catalogSourceList,
            new Action<CatalogSources> () {
                @Override
                public void execute(CatalogSources data) {
                    catalogSources.setSourceList(catalogSourceList);
                }
            }
        );
    }
}
