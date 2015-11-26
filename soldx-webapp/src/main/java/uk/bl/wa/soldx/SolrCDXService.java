/**
 * 
 */
package uk.bl.wa.soldx;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.archive.cdxserver.CDXQuery;
import org.archive.cdxserver.CDXServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Andrew Jackson <Andrew.Jackson@bl.uk>
 *
 */
public class SolrCDXService extends CDXServer {

    private String solrEndpoint;

    public String getSolrEndpoint() {
        return solrEndpoint;
    }

    public void setSolrEndpoint(String solrEndpoint) {
        this.solrEndpoint = solrEndpoint;
        this.setCdxSource(new SolrCDXSource(solrEndpoint));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void postCdx(HttpServletRequest request,
            HttpServletResponse response) {

        // Here we would accept an upload, parse it as CDX data and shuffle it
        // over to Solr.

    }

    public void getXmlQuery(HttpServletRequest request,
            HttpServletResponse response) {

        try {
        Map<String, String> params = request.getParameterMap();
        Map<String, String> query = decodeQueryString(params.get("q"));

        CDXQuery cdxQuery = new CDXQuery();
        cdxQuery.setUrl(query.get("url"));
        cdxQuery.setMatchTypeStr(query.get("type").toLowerCase());

        String startEndUrl[] = urlSurtRangeComputer.determineRange(
                cdxQuery.getUrl(), cdxQuery.getMatchType(), "", "");

        // ...

        } catch (Exception e) {
            try {
                response.getWriter().print(e.toString());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    /**
     * See https://github.com/nla/tinycdxserver/blob/master/src/tinycdxserver/
     * XmlQuery.java
     * 
     * @param q
     * @return
     */
    private static Map<String, String> decodeQueryString(String q) {
        try {
            Map<String, String> m = new HashMap<String, String>();
            for (String entry : q.split(" ")) {
                String[] fields = entry.split(":", 2);
                // we use URLDecoder rather than URLCanonicalize here to match
                // Wayback's encoding behaviour
                // (spaces encoded as + rather than %20)
                String key = URLDecoder.decode(fields[0], "UTF-8");
                String value = URLDecoder.decode(fields[1], "UTF-8");
                m.put(key, value);
            }
            return m;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
