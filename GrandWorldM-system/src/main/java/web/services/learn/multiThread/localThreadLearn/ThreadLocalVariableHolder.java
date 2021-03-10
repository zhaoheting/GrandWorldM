package web.services.learn.multiThread.localThreadLearn;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {
    public static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        /**
         * Every thread will call the initialValue() method of the same thread local object.
         * @return
         */
        @Override
        protected synchronized Integer initialValue() {
            Random random = new Random(47);
            return random.nextInt(10);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; ++i) {
            executorService.execute(new Accessor(i));
        }
        /**
         * Pay attention to the difference between shutdown() and shutdownNow().
         */
        TimeUnit.MILLISECONDS.sleep(50);
        executorService.shutdownNow();
    }
}
