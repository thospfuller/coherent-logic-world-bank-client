/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?date=2000:2002
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */
import com.coherentlogic.wb.client.core.domain.DataPoints

def results = queryBuilder
    .countries("all")
    .indicators("SP.POP.TOTL")
    .setDate("1998:2012")
    .doGet(DataPoints.class)

dataPointsService.save (results)

return results