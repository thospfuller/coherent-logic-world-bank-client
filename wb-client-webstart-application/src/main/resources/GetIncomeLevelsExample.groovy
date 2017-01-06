/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/incomeLevels
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */

import com.coherentlogic.wb.client.core.domain.IncomeLevels

def results = queryBuilder.incomeLevels ().doGet(IncomeLevels.class)

incomeLevelsService.save (results)

return results