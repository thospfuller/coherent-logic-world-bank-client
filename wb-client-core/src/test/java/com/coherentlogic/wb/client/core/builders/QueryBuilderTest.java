package com.coherentlogic.wb.client.core.builders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.ws.rs.core.UriBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.coherentlogic.wb.client.core.domain.Frequency;
import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes;
import com.coherentlogic.wb.client.core.domain.RegionCodes;
import com.coherentlogic.wb.client.core.exceptions.InvalidFromToFormatException;
import com.coherentlogic.wb.client.core.exceptions.InvalidMetatypesException;
import com.coherentlogic.wb.client.core.exceptions.InvalidParameterValueException;

/**
 * Unit test for the {@link QueryBuilder} class.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class QueryBuilderTest {

    private static final String FOO = "foo";

    private UriBuilder uriBuilder = null;

    private QueryBuilder queryBuilder = null;

    @Before
    public void setUp() throws Exception {

        uriBuilder = mock (UriBuilder.class);

        queryBuilder = new QueryBuilder (null, uriBuilder);
    }

    @After
    public void tearDown() throws Exception {
        uriBuilder = null;
        queryBuilder = null;
    }

//    @Test(expected=InvalidParameterValueException.class)
//    public void testSource1 () {
//        queryBuilder.source("-1");
//    }

    @Test(expected=NullPointerException.class)
    public void testSource2 () {
        queryBuilder.source(null);
    }

    @Test(expected=InvalidParameterValueException.class)
    public void assertNotLessThanEqualTo () {
        QueryBuilder.assertNotLessThanEqualTo("foo", 0, 0);
    }

    @Test(expected=InvalidParameterValueException.class)
    public void assertNotLessThanEqualTo1 () {
        QueryBuilder.assertNotLessThanEqualTo("foo", 0, -1);
    }

    @Test
    public void assertNotLessThanEqualTo2 () {
        QueryBuilder.assertNotLessThanEqualTo("foo", 0, 1);
    }

    @Test(expected=InvalidFromToFormatException.class)
    public void testSetDateWithBadDate() {

        String fromTo = "RRRR:SSSS";

        queryBuilder.setDate(fromTo);

        verify (uriBuilder).
            queryParam(any (String.class), any (String.class));
    }

    @Test
    public void testCombineWithOneValue () {
        assertEquals (FOO, QueryBuilder.combine(FOO));
    }

    @Test
    public void testCombineWithTwoValues () {
        assertEquals (FOO + ";" + FOO, QueryBuilder.combine(FOO, FOO));
    }

    @Test(expected=InvalidMetatypesException.class)
    public void testCombineWithZeroValues () {
        QueryBuilder.combine((String[]) null);
    }

    @Test(expected=InvalidMetatypesException.class)
    public void testCombineWithAnEmptyStringArray () {
        QueryBuilder.combine(new String [] {});
    }

    @Test
    public void testSetSingleIsoCode () {
        QueryBuilder queryBuilder =
                new QueryBuilder (null,
                    "http://api.worldbank.org/countries/");

        String result =
            queryBuilder
                .setIsoCodes("foo")
                .getEscapedURI();

        assertEquals ("http://api.worldbank.org/countries/foo", result);
    }

    @Test
    public void testSetMultipleIsoCodes () {
        QueryBuilder queryBuilder =
                new QueryBuilder (null,
                    "http://api.worldbank.org/countries/");

        String result =
            queryBuilder
                .setIsoCodes("br", "gb")
                .getEscapedURI();

        assertEquals ("http://api.worldbank.org/countries/br;gb", result);
    }

    @Test(expected=InvalidMetatypesException.class)
    public void testSetNullIsoCodes () {
        QueryBuilder queryBuilder =
                new QueryBuilder (null,
                    "http://api.worldbank.org/countries/");

        String result =
            queryBuilder
                .setIsoCodes((String []) null)
                .getEscapedURI();

        assertEquals ("http://api.worldbank.org/countries/br;gb", result);
    }

    /**
     * This test shows the IsoCode being set after a query param has been set.
     * The result should be valid.
     */
    @Test
    public void testSetIsoCodeOutOfOrder () {
        QueryBuilder queryBuilder =
                new QueryBuilder (null,
                    "http://api.worldbank.org/countries/");

        String result =
            queryBuilder
                .setPerPage(19)
                .setIsoCodes("foo")
                .getEscapedURI();

        assertEquals (
            "http://api.worldbank.org/countries/foo?per_page=19", result);
    }

    @Test
    public void testIsoCodes () {
        QueryBuilder queryBuilder =
            new QueryBuilder (null,
                "http://api.worldbank.org/countries/");

        String escapedUri =
            queryBuilder
                .countries()
                .setIsoCodes("ae", "af", "ag", "ai")
                .getEscapedURI();

        assertTrue (escapedUri.contains("ae;af;ag;ai"));
    }

//    @Test
//    public void testToStringArray () {
//
//        Iso2Codes[] iso2Codes = new Iso2Codes[] {
//            Iso2Codes.br,
//            Iso2Codes.gb
//        };
//
//        String[] results = QueryBuilder.toStringArray(iso2Codes);
//
//        assertEquals (2, results.length);
//
//        assertEquals (Iso2Codes.br.name(), results[0]);
//        assertEquals (Iso2Codes.gb.name(), results[1]);
//    }
//
//    @Test(expected=InvalidIsoCodeException.class)
//    public void testToStringArrayWithEmptyArray () {
//
//        Iso2Codes[] iso2Codes = new Iso2Codes[] {
//        };
//
//        QueryBuilder.toStringArray(iso2Codes);
//    }
//
//    @Test(expected=InvalidIsoCodeException.class)
//    public void testToStringArrayWithNullArray () {
//
//        Iso2Codes[] iso2Codes = null;
//
//        QueryBuilder.toStringArray(iso2Codes);
//    }

    @Test(expected=InvalidParameterValueException.class)
    public void testSetNullFrequency () {
        queryBuilder.setFrequency(null);
    }

    @Test
    public void testSetFrequencyWithValidValues () {
        queryBuilder.setFrequency(Frequency.monthly);
    }

    @Test(expected=InvalidParameterValueException.class)
    public void testSetNullIncomeLevel () {
        queryBuilder.setIncomeLevel((IncomeLevelCodes) null);
    }

    @Test
    public void testSetIncomeLevelWithValidValues () {
        queryBuilder.setIncomeLevel(IncomeLevelCodes.HIC);
    }

    @Test
    public void testRegions () {

        QueryBuilder queryBuilder =
            new QueryBuilder (null,
                "http://api.worldbank.org/");

        queryBuilder
            .region(RegionCodes.ARB)
            .setPerPage(10);

        String actual = queryBuilder.getEscapedURI();

        assertEquals("http://api.worldbank.org/region/ARB?per_page=10", actual);
    }

    @Test
    public void testSources () {

        QueryBuilder queryBuilder =
            new QueryBuilder (null,
                "http://api.worldbank.org/");

        queryBuilder
            .source("11")
            .setPerPage(10);

        String actual = queryBuilder.getEscapedURI();

        assertEquals("http://api.worldbank.org/source/11?per_page=10", actual);
    }

    @Test
    public void testIndicator () {

        QueryBuilder queryBuilder =
            new QueryBuilder (null,
                "http://api.worldbank.org/");

        queryBuilder
            .indicator("1.1_ACCESS.ELECTRICITY.TOT")
            .setPerPage(10);

        String actual = queryBuilder.getEscapedURI();

        assertEquals("http://api.worldbank.org/indicator/" +
            "1.1_ACCESS.ELECTRICITY.TOT?per_page=10", actual);
    }

    @Test
    public void testTopics () {

        QueryBuilder queryBuilder =
                new QueryBuilder (null,
                    "http://api.worldbank.org/");

            queryBuilder
                .topic("5")
                .setPerPage(10);

            String actual = queryBuilder.getEscapedURI();

            assertEquals(
                "http://api.worldbank.org/topic/5?per_page=10", actual);
    }
}
