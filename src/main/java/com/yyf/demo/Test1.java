package com.yyf.demo;

import java.util.concurrent.Callable;

public class Test1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        System.out.println("test1");

        return "test1";
    }
}
