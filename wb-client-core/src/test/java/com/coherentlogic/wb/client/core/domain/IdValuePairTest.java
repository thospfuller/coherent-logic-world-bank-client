package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.COUNTRIES;
import static com.coherentlogic.wb.client.core.domain.Constants.VALUE;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link IdValuePair} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IdValuePairTest {

    private final Flag flag = new Flag ();

    private IdValuePair idValuePair = null;

    @Before
    public void setUp() throws Exception {
        idValuePair = new IdValuePair();
    }

    @After
    public void tearDown() throws Exception {
        idValuePair = null;
        flag.setValue(false);
    }

    @Test
    public void testSetValue() {
        testSetterMethod (
            idValuePair,
            flag,
            VALUE,
            null,
            COUNTRIES, // Just pick a random string.
            new Action<IdValuePair> () {
                @Override
                public void execute(IdValuePair data) {
                    idValuePair.setValue(COUNTRIES);
                }
            }
        );
    }
}
