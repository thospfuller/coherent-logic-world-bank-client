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

import com.coherentlogic.wb.client.core.domain.Message;
import com.coherentlogic.wb.client.db.integration.repositories.MessageRepository;

/**
 * Unit test for the {@link MessageRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class MessageServiceTest {

    @Autowired
    private MessageService messageService = null;

    private Message message = null;

    @Before
    public void setUp() {
        message = IdentityValueBeanTestHelper.create(Message.class);
    }

    @After
    public void tearDown() {
        message = null;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    @Test
    public void testAllCRUDOperations () {
        new IdentityValueBeanTestHelper<JpaRepository<Message, Long>, Message>
            (messageService.getMessageRepository()).testAllCRUDOperations(message);
    }
}
