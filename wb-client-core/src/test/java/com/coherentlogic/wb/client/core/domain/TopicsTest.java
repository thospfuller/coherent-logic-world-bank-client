package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.TOPIC_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link Topics} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopicsTest {

    private final Flag flag = new Flag ();

    private Topics topics = null;

    @Before
    public void setUp() throws Exception {
        topics = new Topics ();
    }

    @After
    public void tearDown() throws Exception {
        flag.setValue(false);
        topics = null;
    }

    @Test
    public void testSetTopicList() {

        final List<Topic> topicList = new ArrayList<Topic>();

        testSetterMethod (
            topics,
            flag,
            TOPIC_LIST,
            null,
            topicList,
            new Action<Topics> () {
                @Override
                public void execute(Topics data) {
                    data.setTopicList(topicList);
                }
            }
        );
    }
}
