package com.coherentlogic.wb.client.core.drivers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coherentlogic.wb.client.core.exceptions.InvalidResponseReceivedException;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * The World Bank returns some data as uncompressed XML whereas for other calls the data is compressed. This causes
 * problems for specific methods because the XPP driver will throw an exception which looks like there's an issue with
 * the BOM however this is not actually the problem.
 *
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class CustomXppDriver extends XppDriver {

    private static final Logger log = LoggerFactory.getLogger(CustomXppDriver.class);

    public CustomXppDriver() {
        super();
    }

    public CustomXppDriver(NameCoder nameCoder) {
        super(nameCoder);
    }

    /**
     * This method attempts to create a reader using a {@link java.util.zip.GZIPInputStream} and if this fails the
     * inputStream is assumed to not be compressed and the reader is created without wrapping the inputStream in an
     * instance of GZIPInputStream.
     */
    @Override
    public HierarchicalStreamReader createReader(InputStream inputStream) {

        log.debug("createReader: method begins; inputStream: " + inputStream);

        HierarchicalStreamReader result = null;

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        bufferedInputStream.mark(0);

        try {

            GZIPInputStream gzipInputStream = new GZIPInputStream(bufferedInputStream);

            BOMInputStream bomInputStream = new BOMInputStream (gzipInputStream, false, ByteOrderMark.UTF_8);

            result = super.createReader(bomInputStream);

        } catch (IOException topLevelIOException) {

            try {
                bufferedInputStream.reset();
            } catch (IOException ioException) {
                throw new InvalidResponseReceivedException("Unable to reset the inputStream.", ioException);
            }

            result = super.createReader(bufferedInputStream);
        }

        log.debug("createReader: method ends; result: " + result);

        return result;
    }
}
