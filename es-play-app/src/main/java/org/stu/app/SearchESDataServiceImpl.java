package org.stu.app;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SearchESDataServiceImpl implements SearchESDataService {
    @Override
    public SearchESDataResult getResultForSearchTerm(String term) {

        Client client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

        SearchResponse response = client.prepareSearch("twitter")
                .setTypes("tweet")
                .setSearchType(SearchType.DFS_QUERY_AND_FETCH)
                .setQuery(QueryBuilders.matchQuery("message",term))
                .execute()
                .actionGet();

        return new SearchESDataResult(Arrays.asList(response.toString()));
    }
}
