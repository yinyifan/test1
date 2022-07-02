package com.yyf.demo.service;


import com.yyf.demo.Test1;
import com.yyf.demo.Test2;
import com.yyf.demo.Test3;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Service
public class DemoService {

    public String getDemoString(){
        return "tested Successfully!";
    }


    public String testCallable() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable<String>> testCallalbe = Arrays.asList(new Test1(),new Test2(),new Test3());
        List<Future<String>> futures = executorService.invokeAll(testCallalbe);
        return futures.get(0).get()+futures.get(1).get()+futures.get(2).get();
    }


}
