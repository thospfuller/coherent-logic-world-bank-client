package com.coherentlogic.wb.client.db.integration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

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
import com.coherentlogic.wb.client.core.domain.DataPoints;

/**
 * Unit test for the {@link DataPointsDAO} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@Transactional
@ContextConfiguration(locations={"classpath*:/spring-test/application-context.xml"})
public class DataPointsDAOTest {

    @Autowired
    private DataPointsDAO dataPointsDAO = null;

    private DataPoints dataPoints = null;

    static DataPoints createDataPoints () {
        DataPoints result = new DataPoints ();

        List<DataPoint> dataPointList = new ArrayList<DataPoint> ();

        DataPoint dataPoint = DataPointDAOTest.createDataPoint();

        dataPointList.add(dataPoint);

        result.setDataPointList(dataPointList);

        result.setPage(0);
        result.setPages(1);
        result.setPerPage(2);
        result.setTotal(3);

        return result;
    }

    @Before
    public void setUp() {
        dataPoints = createDataPoints ();
    }

    @After
    public void tearDown() {
        dataPoints = null;
    }

    @Test
    public void testAllCRUDOperations () {
        dataPointsDAO.persist(dataPoints);

        Long primaryKey = dataPoints.getPrimaryKey();

        assertNotNull(primaryKey);

        DataPoints dataPoints2 =
            dataPointsDAO.find(primaryKey);

        assertNotNull(dataPoints2);
        assertEquals(dataPoints, dataPoints2);

        dataPoints2.setTotal(2);

        dataPointsDAO.merge(dataPoints2);

        DataPoints dataPoints3 =
            dataPointsDAO.find(primaryKey);

        assertEquals((Integer) 2, dataPoints3.getTotal ());

        dataPointsDAO.remove(dataPoints3);

        DataPoints dataPoints4 =
            dataPointsDAO.find(primaryKey);

        assertNull(dataPoints4);
    }
}
