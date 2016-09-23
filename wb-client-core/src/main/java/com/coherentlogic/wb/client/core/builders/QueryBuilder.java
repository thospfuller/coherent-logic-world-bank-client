package com.coherentlogic.wb.client.core.builders;

import static com.coherentlogic.wb.client.core.domain.Constants.COUNTRIES;
import static com.coherentlogic.wb.client.core.domain.Constants.DATA_CATALOG;
import static com.coherentlogic.wb.client.core.domain.Constants.FREQUENCY;
import static com.coherentlogic.wb.client.core.domain.Constants.GAP_FILL;
import static com.coherentlogic.wb.client.core.domain.Constants.INCOME_LEVEL;
import static com.coherentlogic.wb.client.core.domain.Constants.INCOME_LEVELS;
import static com.coherentlogic.wb.client.core.domain.Constants.INDICATOR;
import static com.coherentlogic.wb.client.core.domain.Constants.INDICATORS;
import static com.coherentlogic.wb.client.core.domain.Constants.LENDING_TYPE;
import static com.coherentlogic.wb.client.core.domain.Constants.LENDING_TYPES;
import static com.coherentlogic.wb.client.core.domain.Constants.METATYPES;
import static com.coherentlogic.wb.client.core.domain.Constants.MRV;
import static com.coherentlogic.wb.client.core.domain.Constants.NO;
import static com.coherentlogic.wb.client.core.domain.Constants.PAGE;
import static com.coherentlogic.wb.client.core.domain.Constants.PER_PAGE;
import static com.coherentlogic.wb.client.core.domain.Constants.REGION;
import static com.coherentlogic.wb.client.core.domain.Constants.SOURCE;
import static com.coherentlogic.wb.client.core.domain.Constants.SOURCES;
import static com.coherentlogic.wb.client.core.domain.Constants.TOPIC;
import static com.coherentlogic.wb.client.core.domain.Constants.TOPICS;
import static com.coherentlogic.wb.client.core.domain.Constants.YES;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.core.UriBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.model.core.builders.AbstractQueryBuilder;
import com.coherentlogic.coherent.data.model.core.builders.rest.AbstractRESTQueryBuilder;
import com.coherentlogic.coherent.data.model.core.cache.CacheServiceProviderSpecification;
import com.coherentlogic.coherent.data.model.core.util.WelcomeMessage;
import com.coherentlogic.wb.client.core.domain.Frequency;
import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes;
import com.coherentlogic.wb.client.core.domain.LendingTypeCodes;
import com.coherentlogic.wb.client.core.domain.PropertyConstants;
import com.coherentlogic.wb.client.core.domain.RegionCodes;
import com.coherentlogic.wb.client.core.exceptions.InvalidFromToFormatException;
import com.coherentlogic.wb.client.core.exceptions.InvalidMetatypesException;
import com.coherentlogic.wb.client.core.exceptions.InvalidParameterValueException;
import com.coherentlogic.wb.client.core.services.GoogleAnalyticsMeasurementService;

/**
 * Class that allows the developer to construct and execute a query to the
 * World Bank web services.
 * <p>
 * Note that this class is <b>not</b> thread-safe and cannot be used as a member
 * -level property -- if this is required, use the
 * {@link com.coherentlogic.wb.client.core.builders#RequestBuilderFactory
 * QueryBuilderFactory} class.
 * <p>
 * In order to facilitate method-chaining each setter method returns a reference
 * to this object.
 * <p>
 * For examples, refer to the {@link
 * com.coherentlogic.wb.client.core.builders#QueryBuilderTest
 * QueryBuilderTest} class.
 *
 * @see http://data.worldbank.org
 * @see http://data.worldbank.org/developers/data-catalog-api
 * @see http://data.worldbank.org/querybuilder
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 *
 * @todo Refactor this class as some of the logic needs to be shared between
 *  this class and the FRED Client.
 */
public class QueryBuilder extends AbstractRESTQueryBuilder<String> {

    private static final Logger log = LoggerFactory.getLogger(QueryBuilder.class);

    static final String[] WELCOME_MESSAGE = {
        "*************************************************************************************************************",
        "***                                                                                                       ***",
        "***                        Welcome to the World Bank Client  (http://bit.ly/1vZ5md8)                      ***",
        "***                                                                                                       ***",
        "***                                        Version 1.0.5-RELEASE                                          ***",
        "***                                                                                                       ***",
        "***                              Please take a moment to follow us on Twitter:                            ***",
        "***                                                                                                       ***",
        "***                                    www.twitter.com/CoherentMktData                                    ***",
        "***                                                                                                       ***",
        "***                                          or on LinkedIn:                                              ***",
        "***                                                                                                       ***",
        "***                            www.linkedin.com/company/coherent-logic-limited                            ***",
        "***                                                                                                       ***",
        "***                            The project and issue tracker can be found here:                           ***",
        "***                                                                                                       ***",
        "***                 https://bitbucket.org/CoherentLogic/coherent-logic-world-bank-client                  ***",
        "***                                                                                                       ***",
        "*** ----------------------------------------------------------------------------------------------------- ***",
        "***                                                                                                       ***",
        "*** BE ADVISED:                                                                                           ***",
        "***                                                                                                       ***",
        "*** This framework uses the Google Analytics Measurement API (GAM) to track framework usage  information. ***",
        "*** As this software is open-source, you are welcomed to review our use of GAM -- please  see  the  class ***",
        "*** named  com.coherentlogic.wb.client.core.services.GoogleAnalyticsMeasurementService   and   feel  free ***",
        "*** to send us an email if you have further questions.                                                    ***",
        "***                                                                                                       ***",
        "*** We do NOT recommend disabling this feature however we offer the option below, just add the following  ***",
        "*** VM parameter and tracking will be disabled:                                                           ***",
        "***                                                                                                       ***",
        "*** -DGOOGLE_ANALYTICS_TRACKING=false                                                                     ***",
        "***                                                                                                       ***",
        "*** ----------------------------------------------------------------------------------------------------- ***",
        "***                                                                                                       ***",
        "*** We offer support and consulting services to businesses that  utilize  this  framework  or  that  have ***",
        "*** custom financial data acquisition projects -- inquiries can be directed to:                           ***",
        "***                                                                                                       ***",
        "*** [M] sales@coherentlogic.com                                                                           ***",
        "*** [T] +1.571.306.3403 (GMT-5)                                                                           ***",
        "***                                                                                                       ***",
        "*************************************************************************************************************"
    };

    /**
     * Todo: Move this message so that it appears in the AbstractQueryBuilder.
     */
    static {

        GoogleAnalyticsMeasurementService googleAnalyticsMeasurementService = new GoogleAnalyticsMeasurementService ();

        if (googleAnalyticsMeasurementService.shouldTrack()) {
            try {
                googleAnalyticsMeasurementService.fireGAFrameworkUsageEvent ();
            } catch (Throwable thrown) {
                log.warn("fireGAFrameworkUsageEvent: method call failed. This exception can be ignored, and the "
                    + "framework will function without issue.", thrown);
            }
        }

        WelcomeMessage welcomeMessage = new WelcomeMessage();

        for (String next : WELCOME_MESSAGE) {
            welcomeMessage.addText(next);
        }

        welcomeMessage.display();
    }

    /**
     * The year pattern -- ie. YYYY.
     */
    private static final String YEAR_PATTERN = "\\d{4}";

    /**
     * The from/to constant -- ie. YYYY:YYYY.
     */
    private static final String FROM_TO_PATTERN =
        YEAR_PATTERN + ":" + YEAR_PATTERN;

    /**
     * The from/to pattern is used to ensure that from/to strings have the
     * proper format.
     */
    private static final Pattern fromToPattern =
        Pattern.compile(FROM_TO_PATTERN);

    /**
     * @see {@link AbstractQueryBuilder}.
     */
    public QueryBuilder (
        RestTemplate restTemplate,
        String uri
    ) {
        super (restTemplate, uri);
    }

    /**
     * @see {@link AbstractQueryBuilder}.
     */
    public QueryBuilder (
        RestTemplate restTemplate,
        UriBuilder uriBuilder
    ) {
        super (restTemplate, uriBuilder);
    }

    /**
     * @see {@link AbstractQueryBuilder}.
     */
    public QueryBuilder(
        RestTemplate restTemplate,
        String uri,
        CacheServiceProviderSpecification<String, Object> cache
    ) {
        super(restTemplate, uri, cache);
    }

    /**
     * @see {@link AbstractQueryBuilder}.
     */
    public QueryBuilder(
        RestTemplate restTemplate,
        UriBuilder uriBuilder,
        CacheServiceProviderSpecification<String, Object> cache
    ) {
        super(restTemplate, uriBuilder, cache);
    }

    /**
     * Extends the path to include countries -- for example:
     *
     * http://api.worldbank.org/countries
     */
    public QueryBuilder countries () {
        return countries ((String[]) null);
    }

    /**
     * Extends the path to include countries -- for example:
     *
     * http://api.worldbank.org/countries
     *
     * @param countries One or more country codes.
     */
    public QueryBuilder countries (String... countries) {
        super.extendPathWith(COUNTRIES);

        if (countries != null)
            extendPathWith(
                combine (countries)
            );

        return this;
    }

    /**
     * Extends the path to include source -- for example:
     *
     * http://api.worldbank.org/source/11
     *
     * Todo Consider adding a topic method that takes a numeric topic parameter.
     *
     * @return A reference to this object.
     */
    public QueryBuilder source (String source) {

        assertNotNull("source", source);

        super.extendPathWith(SOURCE);

        if (source != null)
            super.extendPathWith(source);

        return this;
    }

    /**
     * Extends the path to include sources -- for example:
     *
     * http://api.worldbank.org/sources
     *
     * @return A reference to this object.
     */
    public QueryBuilder sources () {
        super.extendPathWith(SOURCES);

        return this;
    }

    /**
     * Extends the path to include incomeLevel -- for example:
     *
     * http://api.worldbank.org/incomeLevel/LIC?per_page=10
     *
     * @return A reference to this object.
     */
    public QueryBuilder incomeLevel (IncomeLevelCodes incomeLevelCode) {
        super.extendPathWith(INCOME_LEVEL);
        super.extendPathWith(incomeLevelCode.name());

        return this;
    }

    /**
     * Extends the path to include incomeLevels -- for example:
     *
     * http://api.worldbank.org/incomelevels
     *
     * @return A reference to this object.
     */
    public QueryBuilder incomeLevels () {
        super.extendPathWith(INCOME_LEVELS);

        return this;
    }

    /**
     * Extends the path to include indicators -- for example:
     *
     * http://api.worldbank.org/indicators
     *
     * @return A reference to this object.
     */
    public QueryBuilder indicators () {
        return indicators ((String[]) null);
    }

    /**
     * Extends the path to include indicators -- for example:
     *
     * http://api.worldbank.org/indicators
     *
     * @return A reference to this object.
     */
    public QueryBuilder indicators (String... indicators) {
        super.extendPathWith(INDICATORS);

        if (indicators != null)
            extendPathWith(
                combine(indicators));

        return this;
    }

    /**
     * Extends the path to include indicator -- for example:
     *
     * http://api.worldbank.org/indicator
     *
     * @return A reference to this object.
     */
    public QueryBuilder indicator () {
        return indicator(null);
    }

    /**
     * Extends the path to include indicator -- for example:
     *
     * http://api.worldbank.org/indicator
     *
     * @return A reference to this object.
     */
    public QueryBuilder indicator (String indicator) {
        super.extendPathWith(INDICATOR);

        if (indicator != null)
            super.extendPathWith(indicator);

        return this;
    }

    /**
     * Extends the path to include lending types -- for example:
     *
     * http://api.worldbank.org/lendingTypes
     *
     * @return A reference to this object.
     */
    public QueryBuilder lendingTypes () {
        super.extendPathWith(LENDING_TYPES);

        return this;
    }

    /**
     * Extends the path to include a region and region code.
     *
     * @param regionCode The regionCode value; note that if the value is null
     *  nothing will be added to the URL.
     *
     * @return A reference to this object.
     */
    public QueryBuilder region (RegionCodes regionCode) {
        super.extendPathWith(REGION);

        if (regionCode != null)
            super.extendPathWith(regionCode.name());

        return this;
    }

    /**
     * Extends the path to include topics -- for example:
     *
     * http://api.worldbank.org/topics
     *
     * @return A reference to this object.
     */
    public QueryBuilder topics () {
        super.extendPathWith(TOPICS);

        return this;
    }

    /**
     * Extends the path to include topic -- for example:
     *
     * http://api.worldbank.org/topic
     *
     * @return A reference to this object.
     */
    public QueryBuilder topic () {
        return topic (null);
    }

    /**
     * Extends the path to include a topic and topic value-- for example:
     *
     * http://api.worldbank.org/topic/5?per_page=10
     *
     * @param topic The topic value; note that if the value is null nothing will
     *  be added to the URL.
     *
     * @todo Consider adding a topic method that takes a numeric topic
     *  parameter.
     *
     * @return A reference to this object.
     */
    public QueryBuilder topic (String topic) {
        super.extendPathWith(TOPIC);

        if (topic != null)
            super.extendPathWith(topic);

        return this;
    }

    /**
     * Extends the path to include data catalog -- for example:
     *
     * http://api.worldbank.org/datacatalog
     *
     * @return A reference to this object.
     */
    public QueryBuilder dataCatalog () {
        super.extendPathWith(DATA_CATALOG);

        return this;
    }

    /**
     * Method checks that the fromTo format is correct and, if it isn't, an
     * exception will be thrown.
     *
     * @param fromTo A string which should be in the format YYYY:YYYY.
     *
     * @throws InvalidFromToFormatException when the string is not valid.
     */
    private void reviewFromToFormat (String fromTo) {
        Matcher fromToMatcher = fromToPattern.matcher(fromTo);

        if (!fromToMatcher.matches())
            throw new InvalidFromToFormatException("The fromTo value is " +
                "not valid -- this value must be in the format YYYYY:YYYY" +
                "-- ie. '2001:2005'. (fromTo: " + fromTo + ").");
    }

    /**
     * Setter method for the from/to date, which should be in the format
     * YYYY:YYYY.
     *
     * @param fromTo The date range -- ie. 1998:2006.
     */
    public QueryBuilder setDate (String fromTo) {

        reviewFromToFormat (fromTo);

        addParameter(PropertyConstants.DATE, fromTo);

        return this;
    }

    /**
     * Setter method for the from/to date.
     *
     * @param from For example, 1999.
     *
     * @param to For example, 2002.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setDate (String from, String to) {
        return setDate (from + ":" + to);
    }

    /**
     * Method throws an exception if the actual value is less than or equal to
     * the target value.
     *
     * @todo Consider moving this class to the Utils class.
     */
    static void assertNotLessThanEqualTo (
        String param, int target, int actual) {
        if (actual <= target)
            throw new InvalidParameterValueException("The value of the " +
                "parameter named '" + param + "' is " + actual + " and this " +
                "is less than or equal to the expected target value of " +
                target);
    }

    /**
     * Method throws an exception if the actual value is less than or equal to
     * the target value.
     *
     * @todo Consider moving this class to the Utils class.
     */
    static void assertNotNull (
        String param, String value) {
        if (value == null)
            throw new NullPointerException ("The value of the " +
                "parameter named '" + param + "' is null.");
    }

    /**
     * Setter method for the page parameter.
     *
     * @param page The page value.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setPage (int page) {

        assertNotLessThanEqualTo ("page", 0, page);

        addParameter (PAGE, Integer.toString(page));

        return this;
    }

    /**
     * Setter method for the perPage value, which indicates how many results
     * should be shown on each page.
     *
     * @param perPage The perPage value.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setPerPage (int perPage) {

        assertNotLessThanEqualTo ("perPage", 0, perPage);

        addParameter (PER_PAGE, Integer.toString(perPage));

        return this;
    }

    /**
     * Setter method for the most recent values based on the number specified.
     *
     * @param mrv The most recent values.
     *
     * @see http://data.worldbank.org/node/11
     *
     * @todo Should this be an int?
     * @todo We need to check for zero and negative values.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setMRV (int mrv) {

        addParameter (MRV, Integer.toString(mrv));

        return this;
    }

    /**
     * Method sets the gapFill value to either 'yes' or 'no'.
     *
     * @param yesNo True equated to 'yes', 'no' otherwise.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setGapFill (boolean yesNo) {

        String value = yesNo == true ? YES : NO;

        setGapFill (value);

        return this;
    }

    /**
     * Setter method for the gapFill value. The yesNo value must be either
     * 'yes' or 'no'.
     *
     * @todo Check that the string is either yes or no.
     *
     * @return A reference to this object.
     */
    QueryBuilder setGapFill (String yesNo) {

        addParameter (GAP_FILL, yesNo);

        return this;
    }

    /**
     * Setter method for the frequency.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setFrequency (Frequency frequency) {

        if (frequency == null)
            throw new InvalidParameterValueException("The frequency is null.");

        addParameter (FREQUENCY, frequency.toString());

        return this;
    }

    /**
     * Setter method for the lending type.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setLendingType (LendingTypeCodes lendingTypeCode) {

        if (lendingTypeCode == null)
            throw new InvalidParameterValueException(
                "The lendingTypeCode is null.");

        return setLendingType(lendingTypeCode.name());
    }

    /**
     * Setter method for the lending type.
     *
     * @return A reference to this object.
     */
    QueryBuilder setLendingType (String lendingType) {

        addParameter (LENDING_TYPE, lendingType);

        return this;
    }

    /**
     * Setter method for the region.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setRegion (RegionCodes regionCode) {

        addParameter (REGION, regionCode.name());

        return this;
    }

    /**
     * Setter method for the income level.
     *
     * @return A reference to this object.
     */
    QueryBuilder setIncomeLevel (String incomeLevel) {

        addParameter (INCOME_LEVEL, incomeLevel);

        return this;
    }

    /**
     * Setter method for the income level.
     *
     * @return A reference to this object.
     */
    public QueryBuilder setIncomeLevel (IncomeLevelCodes incomeLevelCode) {

        if (incomeLevelCode == null)
            throw new InvalidParameterValueException(
                "The incomeLevelCode is null.");

        return setIncomeLevel(incomeLevelCode.name());
    }

    /**
     * Method combines the array of values into a single string separated by
     * semicolons.
     *
     * @return A single string representing the combined values.
     */
    static String combine (String... values) {
        if (values == null || values.length == 0)
            throw new InvalidMetatypesException(
                "The values passed to the combine method are invalid -- " +
                "these values include: " +
                toString (values));

        String result = "";

        int ctr = (values.length - 1);

        for (String value : values) {

            result += value;

            if (0 < ctr--)
                result += ";";
        }
        return result;
    }

    /**
     * Method creates a single string using the values in the values array.
     *
     * @todo Unit test this class.
     * @todo Move this to the utils package.
     */
    static final String toString (String... values) {

        final String COMMA = ", ";

        String results = null;

        StringBuffer resultsBuffer = new StringBuffer ();

        int ctr = 0;

        if (values == null)
            results = "null array";
        else if (values != null && values.length == 0)
            results = "empty array";
        else {
            for (String next : values) {
                String temp = (next == null) ? "null" : next;
                resultsBuffer.append(next);

                if (ctr++ < values.length) {
                    resultsBuffer.append(COMMA);
                }
                ctr++;
            }
            results.toString();
        }
        return results;
    }

    /**
     * Sets the isoCode in the URI.
     *
     * http://api.worldbank.org/countries/isoCode/
     *
     * @param isoCodes The isoCode.
     *
     * @see http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
     * @see http://en.wikipedia.org/wiki/ISO_3166-1_alpha-3
     * @see http://data.worldbank.org/node/18
     *
     * @return A reference to this object.
     */
    QueryBuilder setIsoCodes (String... isoCodes) {

        String combinedIsoCodes = combine(isoCodes);

        super.extendPathWith(combinedIsoCodes);

        return this;
    }

    /**
     * Setter method for the metatypes parameter.
     *
     * @see http://data.worldbank.org/developers/data-catalog-api
     *
     * @return A reference to this object.
     */
    public QueryBuilder setMetatypes (String... values) {

        String metatypes = combine (values);

        addParameter (METATYPES, metatypes);

        return this;
    }

    @Override
    protected String getKey() {
        return getEscapedURI();
    }

    @Override
    protected <T> T doExecute(Class<T> type) {

        // Using the escapedUri / ASCII string ends up double-encoding the text and this messes up the data because ":"
        // will be encoded firstly to "%3A" and then later to "%253A", which is wrong and results in a 400 being
        // returned from the WB.
        URI uri = getUriBuilder().build();

        return (T) getRestTemplate ().getForObject(uri, type);
    }
}
