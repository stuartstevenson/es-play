package org.stu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stu.app.IndexESDataService;

@Controller
public class IndexESDataController {
    @Autowired
    private IndexESDataService indexESDataService;

    @RequestMapping("/index-data")
    public String indexESData() {
        indexESDataService.indexData();
        return "indexSuccess";
    }


}
