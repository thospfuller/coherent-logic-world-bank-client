package com.coherentlogic.wb.client.core.util;

import static com.coherentlogic.coherent.data.model.core.util.Utils.using;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import com.coherentlogic.coherent.data.model.core.domain.SerializableBean;
import com.coherentlogic.coherent.data.model.core.util.Action;
import com.coherentlogic.coherent.data.model.core.util.Flag;

/**
 * This class contains helper methods that apply strictly to the domain package.
 *
 * @todo Copy/paste anti-pattern from the FRED Client; move this to the data-
 *  -model project.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class TestUtils {

    public static final Date TEST_DATE = using (2014, 02, 21);

    public static final int TEST_INT = 3000;

    public static final long TEST_LONG = (long) TEST_INT;

    public static final String TEST_STRING = "fooBarBazBoo";

    public static PropertyChangeListener createPropertyChangeListener (
        final Flag flag,
        final String propertyName,
        final Object expectedOldValue,
        final Object expectedNewValue
    ) {
        return new PropertyChangeListener () {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                flag.setValue(true);
                assertEquals (
                    propertyName,
                    event.getPropertyName());
                assertEquals (expectedOldValue, event.getOldValue());
                assertEquals (
                    expectedNewValue,
                    event.getNewValue());
            }
        };
    }

    public static void createAndAssignPropertyChangeListener (
        SerializableBean defaultObject,
        final Flag flag,
        final String propertyName,
        final Object expectedOldValue,
        final Object expectedNewValue
    ) {
        PropertyChangeListener propertyChangeListener =
            createPropertyChangeListener (
                flag,
                propertyName,
                expectedOldValue,
                expectedNewValue
            );

        defaultObject.addPropertyChangeListener (propertyChangeListener);
    }

    public static <T extends SerializableBean> void testSetCount(
        T defaultObject,
        Flag flag,
        String propertyName,
        int expectedNewValue,
        Action<T> action
    ) {
        createAndAssignPropertyChangeListener(
            defaultObject,
            flag,
            propertyName,
            0,
            expectedNewValue
        );

        action.execute(defaultObject);

        assertTrue (flag.isValue());
    }

    public static <T extends SerializableBean> void testSetterMethod (
        T defaultObject,
        Flag flag,
        String propertyName,
        Object expectedOldValue,
        Object expectedNewValue,
        Action<T> action
    ) {
        createAndAssignPropertyChangeListener(
            defaultObject,
            flag,
            propertyName,
            expectedOldValue,
            expectedNewValue
        );

        action.execute(defaultObject);

        assertTrue (flag.isValue());
    }
}
