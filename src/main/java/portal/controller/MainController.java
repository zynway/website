package portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@SuppressWarnings({"unused","Duplicates"})
public class MainController extends BaseController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String rootView(){
        return "redirect:/index";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String indexView(){
        return "index";
    }
}
