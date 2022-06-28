package me.jaeseong.java8.completablefuture;

import java.util.concurrent.*;

public class ExecutorsEx {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.submit(() -> System.out.println("thread : " + Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("thread : " + Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("thread : " + Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("thread : " + Thread.currentThread().getName()));
        executorService.submit(() -> System.out.println("thread : " + Thread.currentThread().getName()));
        //종료해주지 않으면 대기합니다.
        executorService.shutdown(); //graceful shutdown 진행중 작업을 끝마치고 종료
        //executorService.shutdownNow(); //즉시 종료

        ScheduledExecutorService scheduledExecutorService =  Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("schedule thread : " + Thread.currentThread().getName());
        },1,2,TimeUnit.SECONDS);


    }

}
