package com.coherentlogic.wb.client.core.exceptions;

import org.springframework.core.NestedRuntimeException;
import com.coherentlogic.wb.client.core.domain.Message;

/**
 * 
 *
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class InvalidRequestException extends NestedRuntimeException {

    private static final long serialVersionUID = -8435729099972282243L;

    private final String id;

    private final String key;

    private final String value;

    public InvalidRequestException(Message error) {
        this ("error.getId()", error.getKey(), error.getValue());
    }

    public InvalidRequestException(String id, String key, String value) {
        super("Message details include id: " + id + ", key: " + key +
            ", value: " + value);

        this.id = id;
        this.key = key;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
