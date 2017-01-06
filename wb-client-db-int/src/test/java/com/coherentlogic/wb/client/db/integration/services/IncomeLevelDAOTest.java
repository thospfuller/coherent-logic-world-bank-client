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

import com.coherentlogic.wb.client.core.domain.IncomeLevel;
import com.coherentlogic.wb.client.db.integration.repositories.IncomeLevelRepository;

/**
 * Unit test for the {@link IncomeLevelRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
@Ignore
public class IncomeLevelDAOTest {

    @Autowired
    private IncomeLevelService incomeLevelDAO = null;

    private IncomeLevel incomeLevel = null;

    @Before
    public void setUp() {
        incomeLevel = IdentityValueBeanTestHelper.create(IncomeLevel.class);
    }

    @After
    public void tearDown() {
        incomeLevel = null;
    }

//    @Test
//    public void testAllCRUDOperations () {
//        new IdentityValueBeanTestHelper<IncomeLevel>
//            (incomeLevelDAO).testAllCRUDOperations(incomeLevel);
//    }
}
