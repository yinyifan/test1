package com.yyf.demo;

import java.util.concurrent.Callable;

public class Test3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Test3");
        return "test3";
    }
}
