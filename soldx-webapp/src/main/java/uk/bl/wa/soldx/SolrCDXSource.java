/**
 * 
 */
package uk.bl.wa.soldx;

import java.io.IOException;

import org.archive.format.cdx.CDXInputSource;
import org.archive.format.gzip.zipnum.ZipNumParams;
import org.archive.util.iterator.CloseableIterator;

/**
 * 
 * This is the newer CDX Server service for Wayback.
 * 
 * It's more powerful, but unfortunately exposes ZipNumParams details which
 * should be handled by the relevant implementation rather than modifying the
 * interface.
 * 
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class SolrCDXSource implements CDXInputSource {

    private String solrEndpoint;

    public SolrCDXSource(String solrEndpoint) {
        this.solrEndpoint = solrEndpoint;
    }

    public CloseableIterator<String> getCDXIterator(String key, String prefix,
            boolean exact, ZipNumParams params) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    public CloseableIterator<String> getCDXIterator(String key, String start,
            String startEndUrl, ZipNumParams params) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    public long getTotalLines() {
        // TODO Auto-generated method stub
        return 0;
    }

}
