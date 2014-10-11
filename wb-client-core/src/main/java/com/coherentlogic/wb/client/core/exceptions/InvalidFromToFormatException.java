package com.coherentlogic.wb.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * An exception that is thrown when the from:to value does not conform to the
 * expected format (ie. YYYY:YYYY or 1998:2001).
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class InvalidFromToFormatException extends NestedRuntimeException {

    private static final long serialVersionUID = 8755729170167236867L;

    public InvalidFromToFormatException(String msg) {
        super(msg);
    }

    public InvalidFromToFormatException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
