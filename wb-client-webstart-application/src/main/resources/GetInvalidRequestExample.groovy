/* This example, which is written in Groovy script, sends a request to the
 * following URI:
 *
 * http://api.worldbank.org/countries
 *
 * Note that the World Bank web services will return an error message if the
 * request is invalid. We intercept this response and convert it into a
 * runtime exception and then throw the exception.
 *
 * @see http://databank.worldbank.org/data/home.aspx
 * @see http://datacatalog.worldbank.org/
 * @see http://data.worldbank.org/developers
 */

// EXPECTED TO FAIL!

Countries result = queryBuilder
    .countries ("NA")
    .setIncomeLevel("Invalid parameter")
    .doGetAsCountries()