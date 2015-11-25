/**
 * 
 */
package uk.bl.wa.soldx;

import java.io.IOException;

import org.archive.util.iterator.CloseableIterator;
import org.archive.wayback.core.CaptureSearchResult;
import org.archive.wayback.exception.ResourceIndexNotAvailableException;
import org.archive.wayback.resourceindex.SearchResultSource;

/**
 * 
 * This is the older search API for Wayback. It's usually exposed as an
 * OpenSearch web service.
 * 
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class SolrSearchResultSource implements SearchResultSource {

    public CloseableIterator<CaptureSearchResult> getPrefixIterator(
            String prefix) throws ResourceIndexNotAvailableException {
        // TODO Auto-generated method stub
        return null;
    }

    public CloseableIterator<CaptureSearchResult> getPrefixReverseIterator(
            String prefix) throws ResourceIndexNotAvailableException {
        // TODO Auto-generated method stub
        return null;
    }

    public void cleanup(CloseableIterator<CaptureSearchResult> c)
            throws IOException {
        // TODO Auto-generated method stub

    }

    public void shutdown() throws IOException {
        // TODO Auto-generated method stub

    }

}
