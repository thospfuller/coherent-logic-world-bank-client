package com.coherentlogic.wb.client.webstart.application;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import com.coherentlogic.coherent.data.model.core.factories.Factory;

/**
 * A class that is used to load examples from a file which is embedded in a jar.
 *
 * @author <a href="support@coherentlogic.com">Support</a>
 */
public class ExampleFactory implements Factory<String> {

    private final String value;

    public ExampleFactory (ClassPathResource resource) throws IOException {
        this (resource.getInputStream());
    }

    public ExampleFactory (InputStream inputStream) throws IOException {
        this(newStringWriter(inputStream));
    }

    public ExampleFactory (StringWriter writer) {
        this (writer.toString());
    }

    public ExampleFactory (String value) {
        this.value = value;
    }

    @Override
    public String getInstance () {
        return value;
    }

    static StringWriter newStringWriter (InputStream inputStream)
        throws IOException {

        StringWriter result = new StringWriter ();

        IOUtils.copy(inputStream, result);

        return result;
    }
}
