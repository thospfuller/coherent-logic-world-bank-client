/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/sources
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */
import com.coherentlogic.wb.client.core.domain.CatalogSources

def results = queryBuilder.sources().doGet(CatalogSources.class)

catalogSourcesDAO.persist (results)

return results