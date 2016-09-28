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

import com.coherentlogic.wb.client.core.domain.IndicatorTopic;

/**
 * Unit test for the {@link IndicatorTopicDAO} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class IndicatorTopicDAOTest {

    static final String NAME1 = "name1";

    @Autowired
    private IndicatorTopicDAO indicatorTopicDAO = null;

    private IndicatorTopic indicatorTopic = null;

    @Before
    public void setUp() {
        indicatorTopic = IdentityValueBeanTestHelper.create(IndicatorTopic.class);
    }

    @After
    public void tearDown() {
        indicatorTopic = null;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    @Test
    public void testAllCRUDOperations () {
        new IdentityValueBeanTestHelper<IndicatorTopic>
            (indicatorTopicDAO).testAllCRUDOperations(indicatorTopic);
    }
}
