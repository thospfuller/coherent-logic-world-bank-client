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
import com.coherentlogic.wb.client.core.domain.IndicatorTopic;
import com.coherentlogic.wb.client.core.domain.IndicatorTopics;
import com.coherentlogic.wb.client.core.domain.Source;
import com.coherentlogic.wb.client.db.integration.repositories.IndicatorRepository;
import com.coherentlogic.wb.client.db.integration.services.IndicatorService;

/**
 * Unit test for the {@link IndicatorRepository} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class IndicatorDAOTest {

    static final String NAME = "nombre",
        NAME1 = "nom",
        SOURCE_NOTE = "sourceNote1",
        SOURCE_ORGANISATION = "sourceOrg1";

    @Autowired
    private IndicatorService indicatorDAO = null;

    private Indicator indicator = null;

    static IndicatorTopics createIndicatorTopics () {

        IndicatorTopics results = new IndicatorTopics ();

        List<IndicatorTopic> indicatorTopicList =
            new ArrayList <IndicatorTopic> ();

        IndicatorTopic indicatorTopic = new IndicatorTopic ();

        indicatorTopic.setId(DataPointCountryDAOTest.ID);
        indicatorTopic.setValue(DataPointCountryDAOTest.VALUEX);

        results.setIndicatorTopicList(indicatorTopicList);

        results.setPage(0);
        results.setPages(1);
        results.setPerPage(2);
        results.setTotal(3);

        return results;
    }

    static Indicator createIndicator () {

        Indicator result = new Indicator ();

        result.setId(DataPointCountryDAOTest.ID);

        result.setIndicatorTopics(createIndicatorTopics());
        result.setName(NAME);

        Source source = IdentityValueBeanTestHelper.create(Source.class);

        result.setSource(source);
        result.setSourceNote(SOURCE_NOTE);
        result.setSourceOrganization(SOURCE_ORGANISATION);

        return result;
    }

    @Before
    public void setUp() {
        indicator = createIndicator ();
    }

    @After
    public void tearDown() {
        indicator = null;
    }

    /**
     * @todo We need to check some of the child objects to ensure changes are
     *  being handled correctly at that level.
     */
    @Test
    public void testAllCRUDOperations () {
        indicatorDAO.save(indicator);

        Long primaryKey = indicator.getPrimaryKey();

        assertNotNull(primaryKey);

        Indicator indicator2 =
            indicatorDAO.findOne(primaryKey);

        assertNotNull(indicator2);
        assertEquals(indicator, indicator2);

        indicator2.setName(NAME1);

        indicatorDAO.save(indicator2);

        Indicator indicator3 =
            indicatorDAO.findOne(primaryKey);

        assertEquals(NAME1, indicator3.getName ());

        indicatorDAO.delete(indicator3);

        Indicator indicator4 =
            indicatorDAO.findOne(primaryKey);

        assertNull(indicator4);
    }
}
