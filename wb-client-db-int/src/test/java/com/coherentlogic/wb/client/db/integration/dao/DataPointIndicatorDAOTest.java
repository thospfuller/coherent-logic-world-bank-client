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

import com.coherentlogic.wb.client.core.domain.DataPointIndicator;

/**
 * Unit test for the {@link DataPointIndicatorDAO} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class DataPointIndicatorDAOTest {

    @Autowired
    private DataPointIndicatorDAO dataPointIndicatorDAO = null;

    private DataPointIndicator dataPointIndicator = null;

    @Before
    public void setUp() {
        dataPointIndicator =
            IdentityValueBeanTestHelper.create(DataPointIndicator.class);
    }

    @After
    public void tearDown() {
        dataPointIndicator = null;
    }

    @Test
    public void testAllCRUDOperations () {
        new IdentityValueBeanTestHelper<DataPointIndicator>
            (dataPointIndicatorDAO).testAllCRUDOperations(dataPointIndicator);
    }
}
