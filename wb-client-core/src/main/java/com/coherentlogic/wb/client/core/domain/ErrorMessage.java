package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.WB_ERROR;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_MESSAGE;

import java.io.Serializable;

import com.coherentlogic.wb.client.core.converters.ErrorMessageConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * A class that represents error messages that are returned by the World Bank.
 *
 * @see <a href="http://data.worldbank.org/node/211">Error Codes</a>
 * @see <a href="http://data.worldbank.org/node/11">Basic Call Structure</a>
 *
 * Generally speaking exceptions are not saved to a database, which explains
 * why this class does not have any JPA annotations.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
//@Entity
//@Table(name=ERROR_TBL)
@XStreamAlias(WB_ERROR)
@XStreamConverter(ErrorMessageConverter.class)
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 6038208781656973486L;

    @XStreamAlias(WB_MESSAGE)
    private Message message = null;

    public ErrorMessage() {
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
