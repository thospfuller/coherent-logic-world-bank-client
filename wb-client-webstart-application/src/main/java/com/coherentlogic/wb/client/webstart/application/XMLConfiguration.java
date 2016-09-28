package com.coherentlogic.wb.client.webstart.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
@Configuration
@ImportResource({"classpath*:/spring-app/h2-jpa-beans.xml", "classpath*:/spring-app/application-context.xml"})
public class XMLConfiguration {

}
