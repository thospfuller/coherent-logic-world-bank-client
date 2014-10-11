package com.coherentlogic.wb.client.core.converters;

/**
 * A simple converter / adapter pattern specification.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 *
 * @param <S> The source type.
 * @param <R> The return (converted value) type.
 */
public interface ConverterSpecification<S, R> {

    R convert (S s);
}
