package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INDICATOR_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link Indicators} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IndicatorsTest {

    private final Flag flag = new Flag ();

    private Indicators indicators = null;

    @Before
    public void setUp() throws Exception {
        indicators = new Indicators();
    }

    @After
    public void tearDown() throws Exception {
        indicators = null;
        flag.setValue(false);
    }

    @Test
    public void testSetIndicatorList() {

        final List<Indicator> indicatorList = new ArrayList<Indicator> ();

        testSetterMethod (
            indicators,
            flag,
            INDICATOR_LIST,
            null,
            indicatorList,
            new Action<Indicators> () {
                @Override
                public void execute(Indicators data) {
                    data.setIndicatorList(indicatorList);
                }
            }
        );
    }
}
