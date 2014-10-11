package com.coherentlogic.wb.client.core.exceptions;

/**
 * An exception that is thrown when there is something wrong with an Iso2Code or
 * Iso3Code -- ie. it's either null, the list is empty, or the value is not
 * recognised by the World Bank.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class InvalidIsoCodeException extends InvalidParameterValueException {

    private static final long serialVersionUID = -3075273132352559688L;

    public InvalidIsoCodeException(String msg) {
        super(msg);
    }

    public InvalidIsoCodeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
