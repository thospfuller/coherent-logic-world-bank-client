package com.coherentlogic.wb.client.core.domain;

import static com.coherentlogic.wb.client.core.domain.Constants.DATA_POINTS_TBL;
import static com.coherentlogic.wb.client.core.domain.Constants.WB_DATA;
import static com.coherentlogic.wb.client.core.domain.PropertyConstants.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coherentlogic.wb.client.core.converters.DataPointsConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * A collection of {@link DataPoint} results -- for example:
 *
 * http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?date=2000:2002
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Entity
@Table(name=DATA_POINTS_TBL)
@XStreamAlias(WB_DATA)
@XStreamConverter(value=DataPointsConverter.class)
public class DataPoints extends PaginationBean {

    private static final long serialVersionUID = 9125816460085924865L;

    @XStreamAlias(WB_DATA)
    @XStreamImplicit
    private List<DataPoint> dataPointList = null;

    @OneToMany(cascade=CascadeType.ALL)
    public List<DataPoint> getDataPointList() {
        return dataPointList;
    }

    public void setDataPointList(List<DataPoint> dataPointList) {

        List<DataPoint> oldValue = this.dataPointList;

        this.dataPointList = dataPointList;

        firePropertyChange(DATA_POINT_LIST, oldValue, dataPointList);
    }
}
