package com.coherentlogic.wb.client.core.builders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.coherentlogic.wb.client.core.domain.AdminRegion;
import com.coherentlogic.wb.client.core.domain.CatalogSource;
import com.coherentlogic.wb.client.core.domain.CatalogSources;
import com.coherentlogic.wb.client.core.domain.Countries;
import com.coherentlogic.wb.client.core.domain.Country;
import com.coherentlogic.wb.client.core.domain.DataPoint;
import com.coherentlogic.wb.client.core.domain.DataPoints;
import com.coherentlogic.wb.client.core.domain.IncomeLevel;
import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes;
import com.coherentlogic.wb.client.core.domain.IncomeLevels;
import com.coherentlogic.wb.client.core.domain.Indicator;
import com.coherentlogic.wb.client.core.domain.IndicatorTopic;
import com.coherentlogic.wb.client.core.domain.IndicatorTopics;
import com.coherentlogic.wb.client.core.domain.Indicators;
import com.coherentlogic.wb.client.core.domain.LendingType;
import com.coherentlogic.wb.client.core.domain.LendingTypes;
import com.coherentlogic.wb.client.core.domain.PaginationSpecification;
import com.coherentlogic.wb.client.core.domain.Region;
import com.coherentlogic.wb.client.core.domain.Source;
import com.coherentlogic.wb.client.core.domain.Topic;
import com.coherentlogic.wb.client.core.domain.Topics;
import com.coherentlogic.wb.client.core.exceptions.InvalidRequestException;

/**
 * Integration test for the {@link QueryBuilder} class.
 *
 * @see http://data.worldbank.org/developers/api-overview
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/application-context.xml")
@SpringBootApplication(scanBasePackages = {"com.coherentlogic.wb.client"})
public class QueryBuilderTest {

    static final String WB_REST_TEMPLATE_ID = "wbRestTemplate";

    @Autowired
    private ApplicationContext context = null;

    private RestTemplate restTemplate = null;

    @Before
    public void setUp() throws Exception {
        restTemplate = (RestTemplate) context.getBean (WB_REST_TEMPLATE_ID);
    }

    @After
    public void tearDown() throws Exception {
        context = null;
        restTemplate = null;
    }

    private void reviewPaginationProperties (
        Integer page,
        Integer pages,
        Integer perPage,
        Integer total,
        PaginationSpecification actual
    ) {
        assertEquals (page, actual.getPage());
        assertEquals (pages, actual.getPages());
        assertEquals (perPage, actual.getPerPage());
        assertEquals (total, actual.getTotal());
    }

    private void reviewIdValuePair (
        String expectedId,
        String expectedValue,
        IdentityValueBean actual
    ) {
        assertNotNull(actual);
        assertEquals (expectedId, actual.getId());
        // The presence of whitespace will cause this test to fail on
        // testGetSources if we don't trim -- we won't see null, and testing for
        // "" doesn't work either.

        String value = actual.getValue();

        if (value != null)
            value = value.trim();

        assertEquals (expectedValue, value);
    }

    /**
     * @see http://api.worldbank.org/v2/datacatalog
     */
//    @Test
//    public void testDataCatalog () {
//        fail ("This test needs to be implemented.");
//    }

    /**
     * This test ensures that errors returned from the World Bank cause an
     * exception to be thrown.
     */
    @Test(expected=InvalidRequestException.class)
    public void testBadRequest() {

         QueryBuilder queryBuilder =
            new QueryBuilder (
                restTemplate,
                "http://api.worldbank.org/countries/"
            );

        queryBuilder
            .setIncomeLevel("Invalid parameter")
            .doGet(Countries.class);
    }

    /**
     * http://api.worldbank.org/sources
     */
    @Test
    public void testGetSources() {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate, "http://api.worldbank.org/sources");

        CatalogSources result = queryBuilder
            .doGet(CatalogSources.class);

        assertNotNull (result);

        reviewPaginationProperties (1, 1, 50, 39, result);

        CatalogSource firstSource = result.getSourceList().get(0);

        // No value will be set here.
        reviewIdValuePair(Long.toString(11L), null, firstSource);

        assertEquals("Africa Development Indicators", firstSource.getName());
    }

    /**
     * http://api.worldbank.org/source/12?per_page=10
     */
    @Test
    public void testGetSources2() {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate, "http://api.worldbank.org");

        CatalogSources result = queryBuilder
            .source("12")
            .setPerPage(10)
            .doGet(CatalogSources.class);

        assertNotNull (result);

        reviewPaginationProperties (1, 1, 10, 1, result);

        CatalogSource firstSource = result.getSourceList().get(0);

        // No value will be set here.
        reviewIdValuePair(Long.toString(12L), null, firstSource);

        assertEquals("Education Statistics", firstSource.getName());
    }

    /**
     * Note that this test is important as an example as we do not use a Sources
     * class -- instead we need to use a CatalogSource.
     *
     * http://api.worldbank.org/source/11?per_page=10
     */
    @Test
    public void testGetSource () {
        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org/");

        CatalogSources sources = queryBuilder
            .source("11")
            .setPerPage(10)
            .doGet(CatalogSources.class);

        CatalogSource expected = new CatalogSource();
        expected.setId("11");
        expected.setName("Africa Development Indicators");

        List<CatalogSource> catalogSourceList = sources.getSourceList();

        CatalogSource actual = catalogSourceList.get(0);

        assertNotNull(actual);

        reviewIdValuePair(expected, actual);
    }

    void reviewIdValuePair (
        IdentityValueBean expected,
        IdentityValueBean actual
    ) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getValue(), actual.getValue());
    }

    void reviewCountry (Country expected, Country actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getIsoCode(), actual.getIsoCode());
        assertEquals(expected.getName(), actual.getName());
        reviewIdValuePair(expected.getRegion(), actual.getRegion());
        reviewIdValuePair(expected.getAdminRegion(), actual.getAdminRegion());
        reviewIdValuePair(expected.getIncomeLevel(), actual.getIncomeLevel());
        reviewIdValuePair(expected.getLendingType(), actual.getLendingType());
        assertEquals(expected.getCapitalCity(), actual.getCapitalCity());
        assertEquals(expected.getLongitude(), actual.getLongitude());
        assertEquals(expected.getLatitude(), actual.getLatitude());
    }

    /**
     * 08 Aug 2014: This method was previously passing however there's something
     *              wrong with the xml returned from the WB.
     *
     * http://api.worldbank.org/countries?per_page=10&incomeLevel=LIC
     */
    @Test
    public void testGetCountries() {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org/countries");

        Countries result = queryBuilder
            .setPerPage(10)
            .setIncomeLevel("LIC")
            .doGet(Countries.class);

        assertNotNull (result);

        reviewPaginationProperties (1, 4, 10, 31, result);

        List<Country> countryList = result.getCountryList();

        Country expected = new Country ();
        expected.setId("BEN");
        expected.setIsoCode("BJ");
        expected.setName("Benin");

        Region region = new Region ();
        region.setId("SSF");
        region.setValue("Sub-Saharan Africa (all income levels)");

        AdminRegion adminRegion = new AdminRegion();
        adminRegion.setId("SSA");
        adminRegion.setValue("Sub-Saharan Africa (developing only)");

        IncomeLevel incomeLevel = new IncomeLevel ();
        incomeLevel.setId("LIC");
        incomeLevel.setValue("Low income");

        LendingType lendingType = new LendingType();
        lendingType.setId ("IDX");
        lendingType.setValue("IDA");

        expected.setRegion(region);
        expected.setAdminRegion(adminRegion);
        expected.setIncomeLevel(incomeLevel);
        expected.setLendingType(lendingType);
        expected.setCapitalCity("Porto-Novo");
        expected.setLatitude("6.4779");
        expected.setLongitude("2.6323");

        Country actual = countryList.get(2);

        reviewCountry(expected, actual);
    }

    /**
     * 08 Aug 2014: This method was previously passing however there's something
     *              wrong with the xml returned from the WB.
     *
     * This is the same test as {@link #testGetCountries()} and the results
     * should be the same, however we use a generic url and set the countries
     * as the path via a method.
     */
    @Test
    public void testGetCountries2() {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org/");

        Countries result = queryBuilder
            .countries()
            .setPerPage(10)
            .setIncomeLevel("LIC")
            .doGet(Countries.class);

        assertNotNull (result);

        reviewPaginationProperties (1, 4, 10, 31, result);

        List<Country> countryList = result.getCountryList();

        Country expected = new Country ();
        expected.setId("BEN");
        expected.setIsoCode("BJ");
        expected.setName("Benin");

        Region region = new Region ();
        region.setId("SSF");
        region.setValue("Sub-Saharan Africa (all income levels)");

        AdminRegion adminRegion = new AdminRegion();
        adminRegion.setId("SSA");
        adminRegion.setValue("Sub-Saharan Africa (developing only)");

        IncomeLevel incomeLevel = new IncomeLevel ();
        incomeLevel.setId("LIC");
        incomeLevel.setValue("Low income");

        LendingType lendingType = new LendingType();
        lendingType.setId ("IDX");
        lendingType.setValue("IDA");

        expected.setRegion(region);
        expected.setAdminRegion(adminRegion);
        expected.setIncomeLevel(incomeLevel);
        expected.setLendingType(lendingType);
        expected.setCapitalCity("Porto-Novo");
        expected.setLatitude("6.4779");
        expected.setLongitude("2.6323");

        Country actual = countryList.get(2);

        reviewCountry(expected, actual);
    }

    @Test
    public void testGetCountriesNOC() {

         QueryBuilder queryBuilder =
            new QueryBuilder (
                restTemplate,
                "http://api.worldbank.org/countries"
            );

        Countries result = queryBuilder
            .setIncomeLevel(IncomeLevelCodes.NOC)
            .doGet(Countries.class);

        assertNotNull (result);

        int size = 48; // subject to change so may want to use greater than #.

        reviewPaginationProperties (1, 1, 50, size, result);

        List<Country> countryList = result.getCountryList();

        assertEquals(size, countryList.size());

        Country expectedCountry = new Country ();

        expectedCountry.setId("AND");
        expectedCountry.setIsoCode("AD");
        expectedCountry.setName("Andorra");

        Region expectedRegion = new Region();
        expectedRegion.setId("ECS");
        expectedRegion.setValue("Europe & Central Asia (all income levels)");

        expectedCountry.setRegion(expectedRegion);

        AdminRegion adminRegion = new AdminRegion();
        adminRegion.setId("");
        adminRegion.setValue("");

        expectedCountry.setAdminRegion(adminRegion);

        IncomeLevel incomeLevel = new IncomeLevel();
        incomeLevel.setId("NOC");
        incomeLevel.setValue("High income: nonOECD");

        expectedCountry.setIncomeLevel(incomeLevel);

        LendingType lendingType = new LendingType ();
        lendingType.setId("LNX");
        lendingType.setValue("Not classified");

        expectedCountry.setLendingType(lendingType);

        expectedCountry.setCapitalCity("Andorra la Vella");

        expectedCountry.setLongitude("1.5218");
        expectedCountry.setLatitude("42.5075");

        Country actualCountry = countryList.get(1);

        reviewCountry (expectedCountry, actualCountry);
    }

    /**
     * http://api.worldbank.org/incomeLevels
     */
    @Test
    public void testIncomeLevels() {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org");

        IncomeLevels result = queryBuilder
            .incomeLevels()
            .doGet(IncomeLevels.class);

        assertNotNull (result);

        reviewPaginationProperties (1, 1, 50, 10, result);

        List<IncomeLevel> incomeLevelList = result.getIncomeLevelList();

        IncomeLevel third = incomeLevelList.get(3);

        reviewIdValuePair("LIC", "Low income", third);
    }

    /**
     * http://api.worldbank.org/countries/all/indicators/
     * SP.POP.TOTL?date=2000:1999
     */
    @Test
    public void testCountriesWithValidFromTo() {

        QueryBuilder queryBuilder =
            new QueryBuilder (
                restTemplate,
                "http://api.worldbank.org/countries/");

        Countries result = queryBuilder
            .setPerPage(10)
            .setDate("1998:2003")
            .doGet(Countries.class);

        assertNotNull (result);

        // Pages and total are subject to change so may want to use greater
        // than #.
        reviewPaginationProperties (1, 27, 10, 264, result);
    }

//    // NOTE THIS TEST RETURNS wb:data AND NOT COUNTRIES AND IT'S NOT CLEAR AT
//    // THE MOMENT IF THIS IS CORRECT OR NOT.
//    /**
//     * http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?date=2000:1999
//     * Returns Data
//     */
//    @Test
//    public void testDataPointsQueryExample() {
//
//        QueryBuilder queryBuilder =
//            new QueryBuilder (
//                restTemplate,
//                "http://api.worldbank.org/");
//
//        DataPoints result = queryBuilder
//            .countries("all")
//            .indicators("SP.POP.TOTL")
//            .setDate("1998:2003")
//            .doGet(DataPoints.class);
//
//        assertEquals (
//            "http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?" +
//            "date=2000:1999",
//            queryBuilder.getEscapedURI());
//
//        assertNotNull (result);
//
//        reviewPaginationProperties (1, 25, 10, 250, result);
//    }

    /**
     * http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?date=2000:1999
     * Returns Data
     */
    @Test
    public void testCountrieBrGbIndicatorsExample() {

        QueryBuilder queryBuilder =
            new QueryBuilder (
                restTemplate,
                "http://api.worldbank.org/");

        DataPoints result = queryBuilder
            .countries("br", "gb")
            .indicators("SP.POP.TOTL")
            .setDate("1998:2003")
            .doGet(DataPoints.class);

        assertEquals (
            "http://api.worldbank.org/countries/br;gb/indicators/SP.POP.TOTL?" +
            "date=1998:2003",
            queryBuilder.getEscapedURI());

        assertNotNull (result);

        reviewPaginationProperties (1, 1, 50, 12, result);

        List<DataPoint> dataPointList = result.getDataPointList();

        assertEquals(12, dataPointList.size());

        DataPoint dataPoint = dataPointList.get(4);

        reviewIdValuePair("SP.POP.TOTL", "Population, total",
            dataPoint.getDataPointIndicator());

        reviewIdValuePair("BR", "Brazil",
            dataPoint.getCountry());

        assertEquals ("1999", dataPoint.getDate());
        // Pages is subject to change so may want to use greater than #.
        assertEquals ("173153066", dataPoint.getValue());
        assertEquals ("0", dataPoint.getDecimal());
    }

    /**
     * This probably should return an error since the from comes after the to
     * date. At any rate we configure the test to check the results as they are
     * returned from the World Bank.
     *
     * http://api.worldbank.org/incomeLevels
     */
    @Test
    public void testCountriesWithInvalidFromTo() {

        QueryBuilder queryBuilder =
            new QueryBuilder (
                restTemplate, "http://api.worldbank.org/countries");

        Countries result = queryBuilder
            .setPerPage(10)
            .setDate("2003:1998")
            .setIncomeLevel("LIC")
            .doGet(Countries.class);

        assertNotNull (result);

        reviewPaginationProperties (1, 4, 10, 31, result);

        // Should we test for the country properties here, or is this query
        // invalid and an exception should have been thrown as the date is
        // wrong?
    }

    /**
     * NOTE: As of August 8th, the URL this test method invokes returns non-
     *       -parseable xml.
     *
     * http://api.worldbank.org/indicators/NY.GDP.MKTP.CD
     */
    @Test
    public void testIndicators() {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org/indicators/NY.GDP.MKTP.CD");

        Indicators result = queryBuilder
            .doGet(Indicators.class);

        assertNotNull (result);

        reviewPaginationProperties (1, 1, 50, 1, result);

        List<Indicator> indicatorList = result.getIndicatorList();

        assertNotNull (indicatorList);

        Indicator firstIndicator = indicatorList.get(0);

        assertEquals ("NY.GDP.MKTP.CD", firstIndicator.getId());
        assertEquals ("GDP at market prices (current US$)", firstIndicator.getName());

        Source source = firstIndicator.getSource();

        reviewIdValuePair(
            "2",
            "World Development Indicators",
            source
        );

        String expectedSourceNote = "GDP at purchaser's prices is the sum " +
            "of gross value added by all resident producers in the economy " +
            "plus any product taxes and minus any subsidies not included in " +
            "the value of the products. It is calculated without making " +
            "deductions for depreciation of fabricated assets or for " +
            "depletion and degradation of natural resources. Data are in " +
            "current U.S. dollars. Dollar figures for GDP are converted from " +
            "domestic currencies using single year official exchange rates. " +
            "For a few countries where the official exchange rate does not " +
            "reflect the rate effectively applied to actual foreign " +
            "exchange transactions, an alternative conversion factor is used.";

        assertEquals (expectedSourceNote, firstIndicator.getSourceNote());

        String expectedSourceOrganization = "World Bank national accounts " +
            "data, and OECD National Accounts data files.";

        assertEquals (expectedSourceOrganization,
            firstIndicator.getSourceOrganization());

        IndicatorTopics indicatorTopics =
            firstIndicator.getIndicatorTopics();

        assertNotNull (indicatorTopics);

        List<IndicatorTopic> indicatorTopicList =
            indicatorTopics.getIndicatorTopicList();

        assertNotNull (indicatorTopicList);

        assertEquals(2,  indicatorTopicList.size());

        // IndicatorTopic indicatorTopic
        IndicatorTopic indicatorTopic = indicatorTopicList.get(1);

        reviewIdValuePair("3", "Economy & Growth", indicatorTopic);
    }

    /**
     * http://api.worldbank.org/lendingTypes
     */
    @Test
    public void testLendingTypes () {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org");

        LendingTypes result = queryBuilder
            .lendingTypes()
            .doGet(LendingTypes.class);

        reviewPaginationProperties(1, 1, 50, 4, result);

        List<LendingType> lendingTypeList = result.getLendingTypeList();

        assertNotNull(lendingTypeList);
        assertEquals(4, lendingTypeList.size());

        LendingType thirdLendingType = lendingTypeList.get(2);

        reviewIdValuePair("IDX", "IDA", thirdLendingType);
    }

    /**
     * @todo We need to complete this test.
     */
    @Test
    public void testIncomeLevel () {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org/");

        IncomeLevels result = queryBuilder
            .incomeLevel(IncomeLevelCodes.LIC)
            .setPerPage(10)
            .doGet(IncomeLevels.class);

        String escapedURI = queryBuilder.getEscapedURI();

        assertEquals (
            "http://api.worldbank.org/incomeLevel/LIC?per_page=10", escapedURI);

        reviewPaginationProperties(1, 1, 10, 1, result);
    }

    /**
     * @todo extend this test to include assertions on the values inside the
     *  result.
     */
    @Test
    public void testTopic () {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org/");

        Topics result = queryBuilder
            .topic("13")
            .setPerPage(100)
            .doGet(Topics.class);

        String escapedURI = queryBuilder.getEscapedURI();

        assertEquals (
            "http://api.worldbank.org/topic/13?per_page=100", escapedURI);

        reviewPaginationProperties(1, 1, 100, 1, result);
    }

    @Test
    public void testTopics () {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org");

        Topics result = queryBuilder
            .topics()
            .doGet(Topics.class);

        reviewPaginationProperties(1, 1, 50, 21, result);

        List<Topic> topicList = result.getTopicList();

        assertNotNull(topicList);
        assertEquals(21, topicList.size());

        Topic thirdTopic = topicList.get(2);

        reviewIdValuePair("3", "Economy & Growth", thirdTopic);

        String expected = 
            "Economic growth is central to economic development. When " +
            "national income grows, real people benefit. While there is no " +
            "known formula for stimulating economic growth, data can help " +
            "policy-makers better understand their countries' economic " +
            "situations and guide any work toward improvement. Data here " +
            "covers measures of economic growth, such as gross domestic " +
            "product (GDP) and gross national income (GNI). It also includes " +
            "indicators representing factors known to be relevant to " +
            "economic growth, such as capital stock, employment, " +
            "investment, savings, consumption, government spending, imports, " +
            "and exports.";

        String actual = thirdTopic.getSourceNote();

        assertEquals (expected, actual);
    }

    /**
     * 08 Aug 2014: This method was previously passing however there's something
     *              wrong with the xml returned from the WB.
     */
    @Test
    public void testIndicator () {

        QueryBuilder queryBuilder =
            new QueryBuilder (restTemplate,
                "http://api.worldbank.org");

        Indicators result = queryBuilder
            .topic("5")
            .indicator()
            .doGet(Indicators.class);

        reviewPaginationProperties(1, 1, 50, 15, result);

        List<Indicator> indicatorList = result.getIndicatorList();

        assertNotNull (indicatorList);

        Indicator firstIndicator = indicatorList.get(2);

        assertEquals ("EG.GDP.PUSE.KO.PP", firstIndicator.getId());
        assertEquals ("GDP per unit of energy use (PPP $ per " +
            "kg of oil equivalent)", firstIndicator.getName());

        Source source = firstIndicator.getSource();

        reviewIdValuePair(
            "2",
            "World Development Indicators",
            source
        );

        String expectedSourceNote = "GDP per unit of energy use is the PPP " +
            "GDP per kilogram of oil equivalent of energy use. PPP GDP is " +
            "gross domestic product converted to current international " +
            "dollars using purchasing power parity rates based on the 2011 " +
            "ICP round. An international dollar has the same purchasing " +
            "power over GDP as a U.S. dollar has in the United States.";

        assertEquals (expectedSourceNote, firstIndicator.getSourceNote());

        String expectedSourceOrganization = "IEA Statistics © OECD/IEA 2014 (http://www.iea.org/stats/index.asp), subject to https://www.iea.org/t&c/termsandconditions/";

        assertEquals (expectedSourceOrganization,
            firstIndicator.getSourceOrganization());

        IndicatorTopics indicatorTopics =
            firstIndicator.getIndicatorTopics();

        assertNotNull (indicatorTopics);

        List<IndicatorTopic> indicatorTopicList =
            indicatorTopics.getIndicatorTopicList();

        assertNotNull (indicatorTopicList);

        assertEquals(1,  indicatorTopicList.size());

        // IndicatorTopic indicatorTopic
        IndicatorTopic indicatorTopic = indicatorTopicList.get(0);

        reviewIdValuePair("5", "Energy & Mining", indicatorTopic);
    }

    // Returns Data.
//    /**
//     * http://api.worldbank.org/en/countries/ind;chn/indicators/DPANUSSPF
//     * ?date=2000:2006&MRV=5&frequency=Q
//     */
//    @Test
//    public void testCountriesWithMRVAndFrequency () {
//        QueryBuilder queryBuilder =
//                new QueryBuilder (restTemplate,
//                    "http://api.worldbank.org/en/");
//
//        Object object = queryBuilder
//            .setCountries()
//            .extendPathWith("ind;chn")
//            .setIndicator()
//            .extendPathWith("DPANUSSPF")
//            .setDate("2000", "2006")
//            .setMRV(5)
//            .setFrequency(Frequency.quarterly)
//            .doGet(Object.class)
//    }

    @Test
    public void testIsoCodes () {
        QueryBuilder queryBuilder =
                new QueryBuilder (restTemplate,
                    "http://api.worldbank.org/");

        Countries countries = 
            queryBuilder
                .countries()
                .setIsoCodes("br", "gb")
                .doGet(Countries.class);

        reviewPaginationProperties(1, 1, 50, 2, countries);

        List<Country> countryList = countries.getCountryList();

        Country actual = countryList.get(1);

        Country expected = new Country ();
        expected.setId("GBR");
        expected.setIsoCode("GB");
        expected.setName("United Kingdom");

        Region region = new Region ();
        region.setId("ECS");
        region.setValue("Europe & Central Asia (all income levels)");

        expected.setRegion(region);

        AdminRegion adminRegion = new AdminRegion();
        adminRegion.setId("");
        adminRegion.setValue("");

        expected.setAdminRegion(adminRegion);

        IncomeLevel incomeLevel = new IncomeLevel ();

        incomeLevel.setId("OEC");
        incomeLevel.setValue("High income: OECD");

        expected.setIncomeLevel(incomeLevel);

        LendingType lendingType = new LendingType ();

        lendingType.setId("LNX");
        lendingType.setValue("Not classified");

        expected.setLendingType(lendingType);

        expected.setCapitalCity("London");

        expected.setLongitude("-0.126236");
        expected.setLatitude("51.5002");

        reviewCountry(expected, actual);
    }
}
