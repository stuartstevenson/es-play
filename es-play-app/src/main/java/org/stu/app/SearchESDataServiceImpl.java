package org.stu.app;

import com.google.common.collect.Lists;
import org.apache.commons.collections.IteratorUtils;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
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

    @Override
    public SearchESDataResult getResultForSearchTerm(String term) {

        Iterable<Property> results = propertyRepository.search(QueryBuilders.fuzzyLikeThisQuery("address", "description")
				.likeText(term)
				.maxQueryTerms(12));

        return new SearchESDataResult(Lists.newArrayList(results));
    }
}
