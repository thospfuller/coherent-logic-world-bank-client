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

import com.coherentlogic.wb.client.core.domain.LendingType;

/**
 * Unit test for the {@link IndicatorTopicDAO} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"/spring/application-context.xml"})
public class LendingTypeDAOTest {

    @Autowired
    private LendingTypeDAO lendingTypeDAO = null;

    private LendingType lendingType = null;

    @Before
    public void setUp() {
        lendingType = IdValuePairTestHelper.create(LendingType.class);
    }

    @After
    public void tearDown() {
        lendingType = null;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    @Test
    public void testAllCRUDOperations () {
        new IdValuePairTestHelper<LendingType>
            (lendingTypeDAO).testAllCRUDOperations(lendingType);
    }
}
