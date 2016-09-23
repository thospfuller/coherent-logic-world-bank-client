/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/indicators/NY.GDP.MKTP.CD
 */

import com.coherentlogic.wb.client.core.domain.Indicators

def results = queryBuilder.doGet(Indicators.class)

indicatorsDAO.persist (results)

return results