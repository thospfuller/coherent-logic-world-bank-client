/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/sources
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */

def results = queryBuilder.sources().doGetAsCatalogSources()

catalogSourcesService.save (results)

return results