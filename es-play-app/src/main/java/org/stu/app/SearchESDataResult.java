package org.stu.app;

import org.stu.domain.Post;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
public class SearchESDataResult {
    private final Collection<Post> items;

    public SearchESDataResult(Collection<Post> items) {
        this.items = items;
    }

    public Collection<Post> getItems() {
        return items;
    }
}
