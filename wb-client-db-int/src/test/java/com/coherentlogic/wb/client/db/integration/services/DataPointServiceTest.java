package com.coherentlogic.wb.client.db.integration.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.coherentlogic.wb.client.core.domain.DataPoint;
import com.coherentlogic.wb.client.core.domain.DataPointCountry;
import com.coherentlogic.wb.client.core.domain.DataPointIndicator;
import com.coherentlogic.wb.client.db.integration.services.DataPointService;

/**
 * Unit test for the {@link DatePointDAO} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class DataPointServiceTest {

    static final String DATE = "2006", DECIMAL = "0", ID = "idx";

    @Autowired
    private DataPointService dataPointService;

    private DataPoint dataPoint = null;

    static DataPoint createDataPoint () {

        DataPoint dataPoint = new DataPoint ();

        DataPointCountry dataPointCountry = IdentityValueBeanTestHelper.create(DataPointCountry.class);

        dataPoint.setCountry(dataPointCountry);

        DataPointIndicator dataPointIndicator = IdentityValueBeanTestHelper.create(DataPointIndicator.class);

        dataPoint.setDataPointIndicator(dataPointIndicator);

        dataPoint.setDate(DATE);
        dataPoint.setDecimal(DECIMAL);
        dataPoint.setId(DataPointCountryServiceTest.VALUEX);
        dataPoint.setValue(DataPointCountryServiceTest.VALUEY);

        return dataPoint;
    }

    @Before
    public void setUp() throws Exception {
        dataPoint = createDataPoint();
    }

    @After
    public void tearDown() throws Exception {
        dataPointService = null;
        dataPoint = null;
    }

    @Test
    public void testAllCRUDOperations () {

        dataPointService.save(dataPoint);

        Long primaryKey = dataPoint.getPrimaryKey();

        assertNotNull(primaryKey);

        DataPoint dataPoint2 = dataPointService.findOne(primaryKey);

        assertNotNull(dataPoint2);
        assertEquals(dataPoint, dataPoint2);

        DataPointIndicator dataPointIndicator = dataPoint.getDataPointIndicator();

        assertNotNull(dataPointIndicator);
        assertNotNull(dataPointIndicator.getId());

        /* @see DataPointIndicatorDAOTest Where this problem doesn't exist.
         * @todo Figure out if this is correct:
         *
         * Calling .persist() will not automatically set the id value. Your JPA
         * provider will ensure that it is set before the entity is finally
         * written to db. So you are right to assume that the id will be
         * assigned when the transaction is committed. But this is not the only
         * possible case. When you call .flush() the very same will happen.
         */

//        assertNotNull(dataPointIndicator.getPrimaryKey());
        assertNotNull(dataPointIndicator.getValue());

        dataPoint2.setValue(DataPointCountryServiceTest.VALUEY);

        dataPointService.save(dataPoint2);

        DataPoint dataPoint3 = dataPointService.findOne(primaryKey);

        assertEquals(DataPointCountryServiceTest.VALUEY, dataPoint3.getValue());

        dataPointService.delete(dataPoint3);

        DataPoint dataPoint4 = dataPointService.findOne(primaryKey);

        assertNull(dataPoint4);
    }
}
