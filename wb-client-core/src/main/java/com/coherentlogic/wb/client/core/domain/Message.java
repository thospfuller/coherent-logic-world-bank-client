package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.KEY;
import static com.coherentlogic.wb.client.core.domain.Constants.MESSAGE_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_MESSAGE;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.coherentlogic.coherent.data.model.core.domain.IdentityValueBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * <?xml version="1.0" encoding="utf-8"?>
 * <wb:error xmlns:wb="http://www.worldbank.org">
 * <wb:message id="120" key="Parameter 'incomelevels' has an invalid value">
 *     The provided parameter value is not valid</wb:message>
 * </wb:error>
 *
 * @todo Should this be serializable?
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=MESSAGE_TBL)
@XStreamAlias(WB_MESSAGE)
public class Message extends IdentityValueBean {

    private static final long serialVersionUID = -8415253588732205072L;

    @XStreamAlias(KEY)
    private String key = null;

    public Message() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
