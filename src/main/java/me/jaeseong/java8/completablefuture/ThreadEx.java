package me.jaeseong.java8.completablefuture;

public class completablefutureEx {

    public static void main(String[] args) throws InterruptedException{

        /*MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread : " + Thread.currentThread().getName());
            }
        });

        thread.start();*/

        Thread thread = new Thread(()->{

            System.out.println("thread1 : " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }

        });
        thread.start();
        thread.join();
        System.out.println("main : " + Thread.currentThread().getName());

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("thread : " + Thread.currentThread().getName());
        }
    }

}
