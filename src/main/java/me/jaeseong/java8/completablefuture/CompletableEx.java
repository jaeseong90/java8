package me.jaeseong.java8.completablefuture;

import java.util.concurrent.*;

public class CompletableEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


      /*

       CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });

        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
            return "callback";
        }).thenAccept(System.out::println);

        */

        /*CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {

            System.out.println("getHello");
            return "hello";
        });

        CompletableFuture<String> resultFuture = future1.thenCompose(CompletableEx::getWorld);
        System.out.println(resultFuture.get());*/

        boolean throwError = true;

        CompletableFuture<String> helo = CompletableFuture.supplyAsync(()->{
            if(throwError){
                throw new IllegalStateException();
            }

            System.out.println("hello" + Thread.currentThread().getName());
            return "hello";
        }).handle((result,ex)->{
            if(ex != null){
                System.out.println(ex);
                return "Error";
            }
            return result;
        });

        System.out.println(helo.get());

    }

    private static CompletableFuture<String> getWorld(String str){
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("getWorld");
            return str + "world";
        });
    }




}
