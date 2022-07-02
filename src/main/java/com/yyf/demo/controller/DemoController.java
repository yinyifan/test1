package com.yyf.demo.controller;

import com.yyf.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/test")
    public String test(){
        return demoService.getDemoString();
    }


    @GetMapping("/callable")
    public String testCallable() throws InterruptedException, ExecutionException {
        return demoService.testCallable();
    }
}
