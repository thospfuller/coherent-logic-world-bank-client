/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/indicators/NY.GDP.MKTP.CD
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */

def results = queryBuilder.indicators ().doGetAsIndicators()

indicatorsService.save (results)

return results