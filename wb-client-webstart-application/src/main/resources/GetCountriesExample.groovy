/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/countries
 */

import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes
import com.coherentlogic.wb.client.core.domain.Countries

return queryBuilder
    .setPerPage(10)
    .setIncomeLevel(IncomeLevelCodes.LIC)
    .doGet(Countries.class);