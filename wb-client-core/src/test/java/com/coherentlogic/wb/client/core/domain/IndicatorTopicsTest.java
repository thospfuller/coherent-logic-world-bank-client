package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INDICATOR_TOPIC_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link IndicatorTopics} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IndicatorTopicsTest {

    private final Flag flag = new Flag ();

    private IndicatorTopics indicatorTopics = null;

    @Before
    public void setUp() throws Exception {
        indicatorTopics = new IndicatorTopics();
    }

    @After
    public void tearDown() throws Exception {
        indicatorTopics = null;
        flag.setValue(false);
    }

    @Test
    public void testSetIndicatorTopicList() {

        final List<IndicatorTopic> indicatorTopicList =
            new ArrayList<IndicatorTopic> ();

        testSetterMethod (
            indicatorTopics,
            flag,
            INDICATOR_TOPIC_LIST,
            null,
            indicatorTopicList,
            new Action<IndicatorTopics> () {
                @Override
                public void execute(IndicatorTopics data) {
                    data.setIndicatorTopicList(indicatorTopicList);
                }
            }
        );
    }
}
