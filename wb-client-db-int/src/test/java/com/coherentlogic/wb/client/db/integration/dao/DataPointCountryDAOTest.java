package com.coherentlogic.wb.client.db.integration.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.DataPointCountry;

/**
 * Unit test for the {@link DataPointCountryDAO} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class DataPointCountryDAOTest {

    /**
     * @todo Move these into a constants class as they are being used elsewhere.
     */
    static final String ID = "idx",
        VALUEX = "valuex",
        VALUEY = "valuey";

    @Autowired
    private DataPointCountryDAO dataPointCountryDAO;

    private DataPointCountry dataPointCountry = null;

    @Before
    public void setUp() throws Exception {
        dataPointCountry = IdentityValueBeanTestHelper.create(DataPointCountry.class);
    }

    @After
    public void tearDown() throws Exception {
        dataPointCountryDAO = null;
        dataPointCountry = null;
    }

    @Test
    public void testAllCRUDOperations () {
        new IdentityValueBeanTestHelper<DataPointCountry>
            (dataPointCountryDAO).testAllCRUDOperations (dataPointCountry);
    }
}
