package org.stu.app;

import com.google.common.collect.Lists;
import com.spatial4j.core.context.SpatialContext;
import com.spatial4j.core.shape.impl.RectangleImpl;
import org.apache.commons.collections.IteratorUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.geo.ShapeRelation;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.stu.domain.Post;
import org.stu.domain.Property;
import org.stu.repositories.PostRepository;
import org.stu.repositories.PropertyRepository;

import java.util.HashSet;
import java.util.Set;

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
    private PropertyRepository propertyRepository;
	@Autowired
	private PostRepository postRepository;
    @Autowired
    private Client client;

    @Override
    public SearchESDataResult getResultForSearchTerm(String term) {

        SearchResponse response = client.prepareSearch("spatial-test")
                .setTypes("spat")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("name", "property"))             // Query
                .setFilter(FilterBuilders.geoShapeFilter("location",
                        new RectangleImpl(0, 10, 0, 10, SpatialContext.GEO), ShapeRelation.WITHIN))   // Filter
                .execute()
                .actionGet();

        SearchHits hits = response.getHits();

        return new SearchESDataResult(null);
    }
}
