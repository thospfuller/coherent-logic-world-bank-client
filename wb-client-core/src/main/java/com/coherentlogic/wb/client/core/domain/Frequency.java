package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.Q;
import static com.coherentlogic.wb.client.core.domain.Constants.M;
import static com.coherentlogic.wb.client.core.domain.Constants.Y;

/**
 * An enumeration for frequencies that are available in the World Bank web
 * services.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public enum Frequency {

    quarterly(Q), monthly(M), yearly(Y);

    private final String value;

    private Frequency(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
