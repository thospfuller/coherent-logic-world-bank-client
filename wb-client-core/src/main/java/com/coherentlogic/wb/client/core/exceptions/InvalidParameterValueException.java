package com.coherentlogic.wb.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * An exception that is thrown when the parameter value is invalid.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class InvalidParameterValueException extends NestedRuntimeException {

    private static final long serialVersionUID = 9137246811154185292L;

    public InvalidParameterValueException(String msg) {
        super(msg);
    }

    public InvalidParameterValueException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
