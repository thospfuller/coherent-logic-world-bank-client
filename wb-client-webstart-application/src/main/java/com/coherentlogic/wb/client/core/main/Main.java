package com.coherentlogic.wb.client.core.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coherentlogic.wb.client.webstart.application.WBClientGUI;

/**
 * 
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class Main {

	private static final String WB_CLIENT_GUI = "wbClientGUI";

	/**
     * The main method uses the Spring application context to get an instance of
     * {@link WBClientGUI} and then displays this object.
     */
    public static void main (String[] unused) throws IOException {

        ApplicationContext applicationContext
            = new ClassPathXmlApplicationContext (
                "application-context.xml");

        WBClientGUI applet = (WBClientGUI)
            applicationContext.getBean(WB_CLIENT_GUI);

        applet.setVisible(true);
    }
}
