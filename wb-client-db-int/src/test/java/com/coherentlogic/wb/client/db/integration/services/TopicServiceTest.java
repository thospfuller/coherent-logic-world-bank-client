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

import com.coherentlogic.wb.client.core.domain.Topic;
import com.coherentlogic.wb.client.db.integration.repositories.TopicRepository;
import com.coherentlogic.wb.client.db.integration.services.TopicService;

/**
 * Unit test for the {@link TopicRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
@Ignore
public class TopicDAOTest {

    @Autowired
    private TopicService topicDAO = null;

    private Topic topic = null;

    @Before
    public void setUp() {
        topic = IdentityValueBeanTestHelper.create(Topic.class);
    }

    @After
    public void tearDown() {
        topic = null;
    }

//    /**
//     * @todo We need to check some of the child objects to ensure changes are
//     *  being handled correctly at that level.
//     */
//    @Test
//    public void testAllCRUDOperations () {
//        new IdentityValueBeanTestHelper<Topic>
//            (topicDAO).testAllCRUDOperations(topic);
//    }
}
