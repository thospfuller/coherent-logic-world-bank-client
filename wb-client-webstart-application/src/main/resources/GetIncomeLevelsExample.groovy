/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/incomeLevels
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */

def results = queryBuilder.incomeLevels ().doGetAsIncomeLevels()

incomeLevelsService.save (results)

return results