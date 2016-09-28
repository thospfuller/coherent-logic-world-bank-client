package com.coherentlogic.wb.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;

/**
 * An exception that is thrown when the response cannot be unmarshalled.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class InvalidResponseReceivedException extends NestedRuntimeException {

    private static final long serialVersionUID = 8625564198110693728L;

    public InvalidResponseReceivedException(String msg) {
        super(msg);
    }

    public InvalidResponseReceivedException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
