package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.DATA_POINT_LIST;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * Unit test for the {@link DataPoints} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class DataPointsTest {

    private final Flag flag = new Flag ();

    private DataPoints dataPoints = null;

    @Before
    public void setUp() throws Exception {
        dataPoints = new DataPoints ();
    }

    @After
    public void tearDown() throws Exception {
        dataPoints = null;
        flag.setValue(false);
    }

    @Test
    public void testSetDataPointList() {
        final List<DataPoint> dataPointList =
            new ArrayList<DataPoint> ();

        testSetterMethod (
            dataPoints,
            flag,
            DATA_POINT_LIST,
            null,
            dataPointList,
            new Action<DataPoints> () {
                @Override
                public void execute(DataPoints data) {
                    data.setDataPointList(dataPointList);
                }
            }
        );
    }
}
