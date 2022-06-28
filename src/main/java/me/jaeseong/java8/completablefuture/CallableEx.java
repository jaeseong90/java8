package me.jaeseong.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException{

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> callable1 = () -> {
            Thread.sleep(1000L);
            return "hello1";
        };

        Callable<String> callable2 = () -> {
            Thread.sleep(1000L);
            return "hello2";
        };

        Callable<String> callable3 = () -> {
            Thread.sleep(1000L);
            return "hello3";
        };

        //묶어서 작업 진행 모든 작업이 끝날때까지 기다림
        List<Future<String>> list = executorService.invokeAll(Arrays.asList(callable1, callable2, callable3));

        String result = executorService.invokeAny(Arrays.asList(callable1, callable2, callable3));

        System.out.println(result);

        list.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }

}
