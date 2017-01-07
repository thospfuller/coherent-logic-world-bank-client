package com.coherentlogic.wb.client.db.integration.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.LendingType;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorTopicRepository;

/**
 * Unit test for the {@link IndicatorTopicRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class LendingTypeServiceTest {

    @Autowired
    private LendingTypeService lendingTypeService = null;

    private LendingType lendingType = null;

    @Before
    public void setUp() {
        lendingType = IdentityValueBeanTestHelper.create(LendingType.class);
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
        new IdentityValueBeanTestHelper<JpaRepository<LendingType, Long>, LendingType>
            (lendingTypeService.getLendingTypeRepository()).testAllCRUDOperations(lendingType);
    }
}
