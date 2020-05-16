package web.controllers;

import org.springframework.web.bind.annotation.RestController;
import web.controllers.interfaces.DemoApi;

@RestController
public class DemoController implements DemoApi {

    @Override
    public String hello() {
        return "hello";
    }


}
