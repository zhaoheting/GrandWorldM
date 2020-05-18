package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Home redirection to swagger api documentation 
 */
@ApiIgnore
@Controller
public class HomeController {
//    @RequestMapping(value = "/")
//    public String index() {
//        System.out.println("swagger-ui.html");
//        return "redirect:swagger-ui.html";
//    }
}
