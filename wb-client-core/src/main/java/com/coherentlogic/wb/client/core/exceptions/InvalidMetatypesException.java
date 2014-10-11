package com.coherentlogic.wb.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * An exception that is thrown when the metatypes are invalid (for example, when
 * they are null).
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class InvalidMetatypesException extends NestedRuntimeException {

    private static final long serialVersionUID = -6808738551238008755L;

    public InvalidMetatypesException(String msg) {
        super(msg);
    }

    public InvalidMetatypesException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
