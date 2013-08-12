package org.stu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.stu.app.SearchESDataService;

/**
 * Created with IntelliJ IDEA.
 * User: stuartjackstevenson@gmail.com
 * Date: 12/08/13
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SearchESDataController {

    @Autowired
    private SearchESDataService searchESDataService;

    @RequestMapping(value = "/search-data", method = RequestMethod.GET)
    public String searchData(final ModelMap modelMap, @RequestParam String q) {
        modelMap.addAttribute("result", searchESDataService.getResultForSearchTerm(q));
        return "searchResults";
    }

}
