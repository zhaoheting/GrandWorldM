package web.services.learn.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 由于线程的本质是互相独立，不可以对其他线程产生影响。如果一个线程抛出异常，那么主线程或者其他线程就挂掉，这是不合理的。
 * 所以任何一个线程抛出的异常是不可以被主线程捕获的。若想要在主线程中处理异常，则应该使用本程序的方法，UncaughtExceptionHandler。
 */
public class ExceptionThread extends Thread {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    private static class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("caught: " + e);
        }
    }

    private static class MyExceptionThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new ExceptionThread();
            thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            return thread;
        }
    }

    public static void main(String[] args) {
        //为所有线程处理一个相同的异常处理器。
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService executor = Executors.newCachedThreadPool(new MyExceptionThreadFactory());
        executor.execute(new ExceptionThread());
        executor.shutdown();
    }
}
