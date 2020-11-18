package com.netty.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author panligang3
 * @create 2020/10/29 2:12 PM
 */
public class JDKFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask<String>(new Task());

        new Thread(futureTask).start();


        System.out.println(futureTask.isDone());


        System.out.println(futureTask.get());


    }

    static class Task implements Callable<String>{

        @Override
        public String call() throws Exception {

           for(int i = 0; i < 10; i++){
               System.out.println("=============" + i);
               Thread.sleep(1000);
           }
           return "ok.";
        }
    }
}
