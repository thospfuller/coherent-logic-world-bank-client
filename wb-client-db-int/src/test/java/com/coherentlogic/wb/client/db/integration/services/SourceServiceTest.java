package com.coherentlogic.wb.client.db.integration.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.Source;
import com.coherentlogic.wb.client.db.integration.repositories.SourceRepository;

/**
 * Unit test for the {@link SourceRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class SourceServiceTest {

    @Autowired
    private SourceService sourceService = null;

    private Source source = null;

    @Before
    public void setUp() {
        source = IdentityValueBeanTestHelper.create(Source.class);
    }

    @After
    public void tearDown() {
        source = null;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    @Test
    public void testAllCRUDOperations () {
        new IdentityValueBeanTestHelper<JpaRepository<Source, Long>, Source>
            (sourceService.getSourceRepository()).testAllCRUDOperations(source);
    }
}
