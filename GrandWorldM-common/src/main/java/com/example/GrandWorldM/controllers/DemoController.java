package com.example.GrandWorldM.controllers;

import com.example.GrandWorldM.controllers.interfaces.DemoApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController implements DemoApi {

    @Override
    public String hello(){
        return "hello";
    }
}
