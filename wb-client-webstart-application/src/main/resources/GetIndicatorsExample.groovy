/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/indicators/NY.GDP.MKTP.CD
 */

import com.coherentlogic.wb.client.core.domain.Indicators

def indicators = queryBuilder.doGet(Indicators.class);

return indicators