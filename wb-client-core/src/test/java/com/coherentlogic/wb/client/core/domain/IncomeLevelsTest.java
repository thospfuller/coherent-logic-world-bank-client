package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.INCOME_LEVEL_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link IncomeLevels} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class IncomeLevelsTest {

    private final Flag flag = new Flag ();

    private IncomeLevels incomeLevels = null;

    @Before
    public void setUp() throws Exception {
        incomeLevels = new IncomeLevels ();
    }

    @After
    public void tearDown() throws Exception {
        incomeLevels = null;
        flag.setValue(false);
    }

    @Test
    public void testSetDataPointList() {
        final List<IncomeLevel> incomeLevelList =
            new ArrayList<IncomeLevel> ();

        testSetterMethod (
            incomeLevels,
            flag,
            INCOME_LEVEL_LIST,
            null,
            incomeLevelList,
            new Action<IncomeLevels> () {
                @Override
                public void execute(IncomeLevels data) {
                    data.setIncomeLevelList(incomeLevelList);
                }
            }
        );
    }
}
