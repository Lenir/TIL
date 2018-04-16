package io.github.lenir;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/view/{viewname}")
    public String view(@PathVariable("viewName") String viewName){
        return viewName;
    }

    @RequestMapping("/value/{value}")
    public String value(@PathVariable("value") String valueName){
        return valueName;
    }
}
