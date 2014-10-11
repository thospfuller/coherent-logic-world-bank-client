package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.PropertyConstants.COUNTRY;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.COUNTRY_LIST;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.DATA_POINT_INDICATOR;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.DATE;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.DECIMAL;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.VALUE;
import static com.coherentlogic.wb.client.core.util.TestUtils.testSetterMethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

public class DataPointTest {

    private final Flag flag = new Flag ();

    private DataPoint dataPoint = null;

    @Before
    public void setUp() throws Exception {
        dataPoint = new DataPoint ();
    }

    @After
    public void tearDown() throws Exception {
        dataPoint = null;
        flag.setValue(false);
    }

    @Test
    public void testSetValue() {
        testSetterMethod (
            dataPoint,
            flag,
            VALUE,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<DataPoint> () {
                @Override
                public void execute(DataPoint data) {
                    dataPoint.setValue(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetDataPointIndicator() {

        final DataPointIndicator dataPointIndicator = new DataPointIndicator ();

        testSetterMethod (
            dataPoint,
            flag,
            DATA_POINT_INDICATOR,
            null,
            dataPointIndicator,
            new Action<DataPoint> () {
                @Override
                public void execute(DataPoint data) {
                    dataPoint.setDataPointIndicator(dataPointIndicator);
                }
            }
        );
    }

    @Test
    public void testSetCountry() {

        final DataPointCountry dataPointCountry = new DataPointCountry();

        testSetterMethod (
            dataPoint,
            flag,
            COUNTRY,
            null,
            dataPointCountry,
            new Action<DataPoint> () {
                @Override
                public void execute(DataPoint data) {
                    dataPoint.setCountry(dataPointCountry);
                }
            }
        );
    }

    @Test
    public void testSetDate() {
        testSetterMethod (
            dataPoint,
            flag,
            DATE,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<DataPoint> () {
                @Override
                public void execute(DataPoint data) {
                    dataPoint.setDate(COUNTRY_LIST);
                }
            }
        );
    }

    @Test
    public void testSetDecimal() {
        testSetterMethod (
            dataPoint,
            flag,
            DECIMAL,
            null,
            COUNTRY_LIST, // Pick a value at random.
            new Action<DataPoint> () {
                @Override
                public void execute(DataPoint data) {
                    dataPoint.setDecimal(COUNTRY_LIST);
                }
            }
        );
    }
}
