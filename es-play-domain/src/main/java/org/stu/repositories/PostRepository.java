package org.stu.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.stu.domain.Post;


public interface PostRepository extends ElasticsearchRepository<Post, Long> {
}
