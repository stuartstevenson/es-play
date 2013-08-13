package org.stu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stu.domain.Post;
import org.stu.repositories.PostRepository;
import org.stu.util.DateProvider;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
@Component
public class IndexESDataServiceImpl implements IndexESDataService {

    @Autowired
    private DateProvider dateProvider;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void indexData() {

        Post post = new Post("Stu's blog post", "some amazingly insightful yet witty comment", dateProvider.now());
        postRepository.save(post);

    }


}
