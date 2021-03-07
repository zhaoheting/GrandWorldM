package web.services.learn.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 展示不正确访问资源造成的后果。
 */
public class EvenChecker extends Thread {

    private IntGenerator generator;

    public EvenChecker(IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int nextValue = generator.next();
            if (nextValue % 2 != 0) {
                generator.cancel();
                System.out.println(nextValue);
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        IntGenerator generator = new EvenGenerator();
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new EvenChecker(generator));
        }
        executorService.shutdown();
    }
}
