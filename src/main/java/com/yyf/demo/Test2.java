package com.yyf.demo;

import java.util.concurrent.Callable;

public class Test2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("test2");
        return "test2";

    }
}
