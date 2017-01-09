/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/countries
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */

import com.coherentlogic.wb.client.core.domain.IncomeLevelCodes

def results = queryBuilder
    .countries ()
    .setPerPage(10)
    .setIncomeLevel(IncomeLevelCodes.LIC)
    .doGetAsCountries()

countriesService.save (results)

return results