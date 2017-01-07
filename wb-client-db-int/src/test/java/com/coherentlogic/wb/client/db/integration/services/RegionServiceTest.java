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

import com.coherentlogic.wb.client.core.domain.Region;
import com.coherentlogic.wb.client.db.integration.repositories.RegionRepository;

/**
 * Unit test for the {@link RegionRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
@Ignore
public class RegionDAOTest {

    @Autowired
    private RegionService regionDAO = null;

    private Region region = null;

    @Before
    public void setUp() {
        region = IdentityValueBeanTestHelper.create(Region.class);
    }

    @After
    public void tearDown() {
    	region = null;
    }

//    /**
//     * @todo We need to check some of the child objects to ensure changes are
//     *  being handled correctly at that level.
//     */
//    @Test
//    public void testAllCRUDOperations () {
//        new IdentityValueBeanTestHelper<RegionService, Region>
//            (regionDAO).testAllCRUDOperations(region);
//    }
}
