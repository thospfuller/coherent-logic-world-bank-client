package com.coherentlogic.wb.client.webstart.application;

import java.lang.reflect.Method;
import java.util.List;

/**
 * This class is responsible for transforming an Object into a String by
 * converting the results of calls to the various getter methods into instances
 * of String.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
public class ObjectStringifier {

    public static final int FIRST_LETTER = 3;

    public static final String GET = "get", TAB = "    ";

    /**
     * Method converts the contents of the object into a String and returns the
     * result.
     */
    public String toString (Object object) {
        return toString (object, new StringBuffer(), 1);
    }

    /**
     * Method converts the contents of the object into a String and returns the
     * result.
     *
     * @param object The object being converted into a String.
     * @param buffer Stores the entire String.
     * @param tabCount The number of tabs by which this object should be
     *  printed.
     * @return The String value of the buffer parameter.
     */
    public String toString (Object object, StringBuffer buffer, int tabCount) {

        String className = object.getClass().getName();

        buffer.append("\n" + className);

        Method[] methods = object.getClass().getMethods();

        for (Method method : methods) {

            String name = method.getName();

            Class<?>[] parameters = method.getParameterTypes();

            if (name.startsWith(GET) && (parameters.length == 0)) {

                Object value = null;

                try {
                    value = method.invoke(object);

                    if (value instanceof List) {
                        List<?> objects = (List<?>) value;
                        toString (objects, buffer, tabCount);
                    } else {

                        name = name.substring(FIRST_LETTER);
    
                        String tabs = getTabs(tabCount);
    
                        buffer.append("\n" + tabs + name + ": " + value);
                    }
                } catch (Throwable throwable) {
                    throw new StringificationFailedException(
                        "Unable to create a string for the object: " + object,
                        throwable
                    );
                }
            }
        }
        return buffer.toString();
    }

    /**
     * Method converts the list of objects into a string.
     *
     * @param objects The list of objects being converted.
     * @param buffer Stores the current String.
     * @param tabCount The number of tabs by which this object should be moved.
     */
    public void toString (
        List objects,
        StringBuffer buffer,
        int tabCount
    ) {

        for (Object object : objects) {
            toString (object, buffer, tabCount + 1);
        }
    }

    /**
     * Method creates n tabs using only whitespace and then returns the result.
     */
    String getTabs (int tabs) {

        String result = "";

        for (int ctr = 0; ctr < tabs; ctr++)
            result += TAB;

        return result;
    }
}
