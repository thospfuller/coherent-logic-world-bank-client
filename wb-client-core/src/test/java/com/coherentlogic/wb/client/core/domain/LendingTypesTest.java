package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.LENDING_TYPE_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link LendingTypes} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class LendingTypesTest {

    private final Flag flag = new Flag ();

    private LendingTypes lendingTypes = null;

    @Before
    public void setUp() throws Exception {
        lendingTypes = new LendingTypes ();
    }

    @After
    public void tearDown() throws Exception {
        lendingTypes = null;
        flag.setValue(false);
    }

    @Test
    public void testSetLendingTypeList() {
        final List<LendingType> lendingTypeList = new ArrayList<LendingType> ();

        testSetterMethod (
            lendingTypes,
            flag,
            LENDING_TYPE_LIST,
            null,
            lendingTypeList,
            new Action<LendingTypes> () {
                @Override
                public void execute(LendingTypes data) {
                    data.setLendingTypeList(lendingTypeList);
                }
            }
        );
    }
}
