package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.COUNTRY_LIST;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INDICATOR_TOPICS;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.NAME;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE_NOTE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE_ORGANIZATION;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link Indicator} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IndicatorTest {

    private final Flag flag = new Flag ();

    private Indicator indicator = null;

    @Before
    public void setUp() throws Exception {
        indicator = new Indicator();
    }

    @After
    public void tearDown() throws Exception {
        indicator = null;
        flag.setValue(false);
    }

    @Test
    public void testSetName() {
        testSetterMethod (
            indicator,
            flag,
            NAME,
            null,
            COUNTRY_LIST,
            new Action<Indicator> () {
                @Override
                public void execute(Indicator data) {
                    data.setName(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetSource() {

        final Source source = new Source ();

        testSetterMethod (
            indicator,
            flag,
            SOURCE,
            null,
            source,
            new Action<Indicator> () {
                @Override
                public void execute(Indicator data) {
                    data.setSource(source);
                }
            }
        );
    }

    @Test
    public void testSetSourceNote() {
        testSetterMethod (
            indicator,
            flag,
            SOURCE_NOTE,
            null,
            COUNTRY_LIST,
            new Action<Indicator> () {
                @Override
                public void execute(Indicator data) {
                    data.setSourceNote(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetSourceOrganization() {
        testSetterMethod (
            indicator,
            flag,
            SOURCE_ORGANIZATION,
            null,
            COUNTRY_LIST,
            new Action<Indicator> () {
                @Override
                public void execute(Indicator data) {
                    data.setSourceOrganization(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetIndicatorTopics() {

        final IndicatorTopics indicatorTopics = new IndicatorTopics ();

        testSetterMethod (
            indicator,
            flag,
            INDICATOR_TOPICS,
            null,
            indicatorTopics,
            new Action<Indicator> () {
                @Override
                public void execute(Indicator data) {
                    data.setIndicatorTopics(indicatorTopics);
                }
            }
        );
    }
}
