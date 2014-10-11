/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/sources
 */
import com.coherentlogic.wb.client.core.domain.CatalogSources

return queryBuilder.doGet(CatalogSources.class);