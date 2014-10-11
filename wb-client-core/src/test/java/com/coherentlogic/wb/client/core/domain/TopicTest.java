package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.COUNTRY_LIST;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.SOURCE_NOTE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.VALUE;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link Topic} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TopicTest {

    private final Flag flag = new Flag ();

    private Topic topic = null;

    @Before
    public void setUp() throws Exception {
        topic = new Topic ();
    }

    @After
    public void tearDown() throws Exception {
        flag.setValue(false);
        topic = null;
    }

    @Test
    public void testSetValue() {
        testSetterMethod (
            topic,
            flag,
            VALUE,
            null,
            COUNTRY_LIST,
            new Action<Topic> () {
                @Override
                public void execute(Topic data) {
                    data.setValue(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetSourceNote() {
        testSetterMethod (
            topic,
            flag,
            SOURCE_NOTE,
            null,
            COUNTRY_LIST,
            new Action<Topic> () {
                @Override
                public void execute(Topic data) {
                    data.setSourceNote(COUNTRY_LIST);
                }
            }
        );
    }
}
