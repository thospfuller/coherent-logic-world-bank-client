/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?date=2000:2002
 */
import com.coherentlogic.wb.client.core.domain.DataPoints

return queryBuilder
    .countries("all")
    .indicators("SP.POP.TOTL")
    .setDate("1998:2012")
    .doGet(DataPoints.class)