package org.stu.app;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public interface SearchESDataService {
    SearchESDataResult getResultForSearchTerm(String term);
}
