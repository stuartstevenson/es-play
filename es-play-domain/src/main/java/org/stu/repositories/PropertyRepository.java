package org.stu.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.stu.domain.Property;

/**
 * Created with IntelliJ IDEA.
 * User: stuarts
 * Date: 15/08/13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public interface PropertyRepository extends ElasticsearchRepository<Property, Long> {
}
