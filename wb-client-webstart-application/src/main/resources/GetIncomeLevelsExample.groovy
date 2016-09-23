/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/incomeLevels
 */

import com.coherentlogic.wb.client.core.domain.IncomeLevels

def results = queryBuilder.incomeLevels ().doGet(IncomeLevels.class)

incomeLevelsDAO.persist (results)

return results