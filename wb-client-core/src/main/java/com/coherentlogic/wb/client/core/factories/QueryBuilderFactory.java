package com.coherentlogic.wb.client.core.factories;

import org.springframework.web.client.RestTemplate;

import com.coherentlogic.coherent.data.adapter.core.factories.AbstractQueryBuilderFactory;
import com.coherentlogic.wb.client.core.builders.QueryBuilder;

/**
 * A factory which is used for creating instances of QueryBuilder.
 * <p>
 * Since the QueryBuilder is not thread-safe, it cannot be set as a member variable -- instead, use this factory and
 * call {@link #getInstance()} whenever you need a new QueryBuilder.
 * <p>
 * This class can be extended, for example, if you need to always return the same value for some query parameter.
 * <p>
 * @author <a href="support@coherentlogic.com">Support</a>
 */
public class QueryBuilderFactory extends AbstractQueryBuilderFactory {

    public QueryBuilderFactory(RestTemplate restTemplate, String uri) {
        super(restTemplate, uri);
    }

    @Override
    public QueryBuilder getInstance() {

        RestTemplate restTemplate = getRestTemplate();

        String uri = getUri();

        QueryBuilder result = new QueryBuilder (restTemplate, uri);

        return result;
    }
}
