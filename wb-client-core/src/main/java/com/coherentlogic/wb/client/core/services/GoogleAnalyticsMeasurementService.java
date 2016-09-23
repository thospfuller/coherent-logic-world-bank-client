package com.coherentlogic.wb.client.core.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coherentlogic.gama.client.core.builders.QueryBuilder;

/**
 * Class is used to send events to Google Analytics via the Measurement API.
 *
 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/devguide">Working with the
 *  Measurement Protocol</a>
 *
 * @see <a href="https://ga-dev-tools.appspot.com/hit-builder/">Hit Builder</a>
 *
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class GoogleAnalyticsMeasurementService {

    private static final Logger log = LoggerFactory.getLogger(GoogleAnalyticsMeasurementService.class);

    static final String GOOGLE_ANALYTICS_TRACKING_KEY = "GOOGLE_ANALYTICS_TRACKING";

    public boolean shouldTrack () {

        String gatValue = System.getProperty(GOOGLE_ANALYTICS_TRACKING_KEY);

        return (gatValue == null || Boolean.parseBoolean(gatValue));
    }

    /**
     *
     */
    public void fireGAFrameworkUsageEvent () {

        log.debug("fireGAFrameworkUsageEvent: method begins.");

        // WARNING: The QueryBuilder must be used once before this will be called so if you see nothing in GA when
        //          testing this, that is the reason why.
        String response = new QueryBuilder ()
            .withV1()
            .withTid("N/A")
            .withCIDAsRandomUUID()
            .withTAsEvent()
            .withEc("World Bank Client Framework Usage") // event category
            .withAn("World Bank Client") // application name
            .withEa("World Bank Client Framework Started") // event action
            .withAv("Version 1.0.5-RELEASE") // Application version.
            .withEl("Version 1.0.5-RELEASE")
            .doPost();

        log.debug("fireGAFrameworkUsageEvent: method ends; response: " + response);
    }
}
