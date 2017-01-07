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

import com.coherentlogic.wb.client.core.domain.IndicatorSource;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorSourceRepository;
import com.coherentlogic.wb.client.db.integration.services.IndicatorSourceService;

/**
 * Unit test for the {@link IndicatorSourceRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
@Ignore
public class IndicatorSourceDAOTest {

    static final String NAME1 = "name1";

    @Autowired
    private IndicatorSourceService indicatorSourceDAO = null;

    private IndicatorSource indicatorSource = null;

    @Before
    public void setUp() {
        indicatorSource = IdentityValueBeanTestHelper.create(IndicatorSource.class);
    }

    @After
    public void tearDown() {
        indicatorSource = null;
    }

//    /**
//     * @todo We need to check some of the child objects to ensure changes are
//     *  being handled correctly at that level.
//     */
//    @Test
//    public void testAllCRUDOperations () {
//        new IdentityValueBeanTestHelper<IndicatorSource>
//            (indicatorSourceDAO).testAllCRUDOperations(indicatorSource);
//    }
}
