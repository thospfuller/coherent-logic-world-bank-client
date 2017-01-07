package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.IncomeLevel;
import com.coherentlogic.wb.client.core.domain.IncomeLevels;
import com.coherentlogic.wb.client.db.integration.repositories.IncomeLevelsRepository;
import com.coherentlogic.wb.client.db.integration.services.IncomeLevelsService;

/**
 * Unit test for the {@link IncomeLevelsRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class IncomeLevelsDAOTest {

    @Autowired
    private IncomeLevelsService incomeLevelsDAO = null;

    private IncomeLevels incomeLevels = null;

    static IncomeLevels createIncomeLevels () {

        IncomeLevels result = new IncomeLevels ();

        IncomeLevel incomeLevel =
            IdentityValueBeanTestHelper.create(IncomeLevel.class);

        List<IncomeLevel> incomeLevelList = new ArrayList<IncomeLevel> ();
        
        incomeLevelList.add(incomeLevel);

        result.setIncomeLevelList(incomeLevelList);

        result.setPage(0);
        result.setPages(1);
        result.setPerPage(2);
        result.setTotal(3);

        return result;
    }

    @Before
    public void setUp() {
        incomeLevels = createIncomeLevels ();
    }

    @After
    public void tearDown() {
        incomeLevels = null;
    }

    @Test
    public void testAllCRUDOperations () {
        incomeLevelsDAO.save(incomeLevels);

        Long primaryKey = incomeLevels.getPrimaryKey();

        assertNotNull(primaryKey);

        IncomeLevels incomeLevels2 =
            incomeLevelsDAO.findOne(primaryKey);

        assertNotNull(incomeLevels2);
        assertEquals(incomeLevels, incomeLevels2);

        incomeLevels2.setPerPage(12);

        incomeLevelsDAO.save(incomeLevels2);

        IncomeLevels incomeLevels3 =
            incomeLevelsDAO.findOne(primaryKey);

        assertEquals((Integer) 12, incomeLevels3.getPerPage());

        incomeLevelsDAO.delete(incomeLevels3);

        IncomeLevels incomeLevels4 =
            incomeLevelsDAO.findOne(primaryKey);

        assertNull(incomeLevels4);
    }
}
