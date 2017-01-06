package com.coherentlogic.wb.client.db.integration.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.DataPointIndicator;
import com.coherentlogic.wb.client.db.integration.repositories.DataPointIndicatorRepository;
import com.coherentlogic.wb.client.db.integration.services.DataPointIndicatorService;

/**
 * Unit test for the {@link DataPointIndicatorRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
@Ignore
public class DataPointIndicatorDAOTest {

    @Autowired
    private DataPointIndicatorService dataPointIndicatorDAO = null;

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

//    @Test
//    public void testAllCRUDOperations () {
//        new IdentityValueBeanTestHelper<DataPointIndicator>
//            (dataPointIndicatorDAO).testAllCRUDOperations(dataPointIndicator);
//    }
}
