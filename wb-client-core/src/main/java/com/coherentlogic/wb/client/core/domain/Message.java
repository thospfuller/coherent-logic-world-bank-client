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

	private static final long serialVersionUID = -7537455771776289598L;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }
}
