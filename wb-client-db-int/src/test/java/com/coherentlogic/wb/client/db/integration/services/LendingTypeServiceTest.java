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

import com.coherentlogic.wb.client.core.domain.LendingType;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorTopicRepository;
import com.coherentlogic.wb.client.db.integration.services.LendingTypeService;

/**
 * Unit test for the {@link IndicatorTopicRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
@Ignore
public class LendingTypeDAOTest {

    @Autowired
    private LendingTypeService lendingTypeDAO = null;

    private LendingType lendingType = null;

    @Before
    public void setUp() {
        lendingType = IdentityValueBeanTestHelper.create(LendingType.class);
    }

    @After
    public void tearDown() {
        lendingType = null;
    }

//    /**
//     * @todo We need to check some of the child objects to ensure changes are
//     *  being handled correctly at that level.
//     */
//    @Test
//    public void testAllCRUDOperations () {
//        new IdentityValueBeanTestHelper<LendingType>
//            (lendingTypeDAO).testAllCRUDOperations(lendingType);
//    }
}
