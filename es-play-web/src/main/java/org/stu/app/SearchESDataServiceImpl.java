package org.stu.app;

import org.springframework.stereotype.Component;

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
        return new SearchESDataResult(null);
    }
}
