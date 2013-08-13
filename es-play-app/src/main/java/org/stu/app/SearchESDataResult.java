package org.stu.app;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
public class SearchESDataResult {
    private final List<String> items;

    public SearchESDataResult(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }
}
