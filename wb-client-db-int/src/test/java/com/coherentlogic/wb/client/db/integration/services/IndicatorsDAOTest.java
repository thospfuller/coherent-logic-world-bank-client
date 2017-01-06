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

import com.coherentlogic.wb.client.core.domain.Indicator;
import com.coherentlogic.wb.client.core.domain.Indicators;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorsRepository;
import com.coherentlogic.wb.client.db.integration.services.IndicatorsService;

/**
 * Unit test for the {@link IndicatorsRepository} class.
 *
 * @todo Expand the coverage of this test to include the children.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class IndicatorsDAOTest {

    static final String NAME = "nombre",
        NAME1 = "nom",
        SOURCE_NOTE = "sourceNote1",
        SOURCE_ORGANISATION = "sourceOrg1";

    @Autowired
    private IndicatorsService indicatorsDAO = null;

    private Indicators indicators = null;

    static Indicators createIndicators () {
        Indicators result = new Indicators ();

        List<Indicator> indicatorList = new ArrayList<Indicator> ();

        indicatorList.add (IndicatorDAOTest.createIndicator());

        result.setIndicatorList (indicatorList);
        result.setPage (0);
        result.setPages (1);
        result.setPerPage (2);
        result.setTotal (3);
        
        return result;
    }

    @Before
    public void setUp() {
        indicators = createIndicators ();
    }

    @After
    public void tearDown() {
        indicators = null;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    @Test
    public void testAllCRUDOperations () {
        indicatorsDAO.save(indicators);

        Long primaryKey = indicators.getPrimaryKey();

        assertNotNull(primaryKey);

        Indicators indicators2 =
            indicatorsDAO.findOne(primaryKey);

        assertNotNull(indicators2);
        assertEquals(indicators, indicators2);

        indicators2.setPage(12);

        indicatorsDAO.save(indicators2);

        Indicators indicators3 =
            indicatorsDAO.findOne(primaryKey);

        assertEquals((Integer) 12, indicators3.getPage());

        indicatorsDAO.delete(indicators3);

        Indicators indicators4 =
            indicatorsDAO.findOne(primaryKey);

        assertNull(indicators4);
    }
}
