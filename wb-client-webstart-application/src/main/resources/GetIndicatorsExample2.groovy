/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/countries/all/indicators/SP.POP.TOTL?date=2000:2002
 */
import com.coherentlogic.wb.client.core.domain.DataPoints

import joinery.DataFrame
import joinery.DataFrame.PlotType

def results = queryBuilder
    .countries("br")
    .indicators("NY.GDP.MKTP.CD")
    .setDate("1970:2016")
    .doGet(DataPoints.class)

indicatorsDAO.persist(results)

def dataFrame = new DataFrame<Object> ()

def dates = [] as List
def values = [] as List<BigDecimal>

def sortedDataPoints = results.dataPointList.sort { it.date }

sortedDataPoints.each {
    dates << it.date
    values << new java.math.BigDecimal (it.value)
}

dataFrame.add((Object) "Date", (List<Object>) dates)
dataFrame.add((Object) "Values", (List<Object>) values)

dataFrame.plot(PlotType.LINE)
dataFrame.show()

return results