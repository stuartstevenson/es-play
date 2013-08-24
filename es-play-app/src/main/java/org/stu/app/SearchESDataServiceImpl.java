package org.stu.app;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.elasticsearch.index.query.FilterBuilders.boolFilter;
import static org.elasticsearch.index.query.FilterBuilders.geoBoundingBoxFilter;
import static org.elasticsearch.index.query.FilterBuilders.termFilter;
import static org.elasticsearch.index.query.QueryBuilders.filteredQuery;
import static org.elasticsearch.index.query.QueryBuilders.fuzzyLikeThisQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SearchESDataServiceImpl implements SearchESDataService {

    @Autowired
    private Client client;

    @Override
    public SearchESDataResult getResultForSearchTerm(String term, String type) {

        SearchResponse searchResponse = client.prepareSearch("property-index")
                .setTypes("property")
                .setQuery(filteredQuery(fuzzyLikeThisQuery("address", "description").likeText(term),
                                        boolFilter()
                                            .must(geoBoundingBoxFilter("point").topLeft(40.73, -74.1).bottomRight(40.71, -73.99))
                                            .mustNot(termFilter("prop_type", type))
                ))
                .execute().actionGet();

        return new SearchESDataResult(null);
    }
}
