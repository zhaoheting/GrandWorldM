package web.services.learn.multiThread.threadPool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue() {
        return i.get();
    }

    public void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("timer end.");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        //There are two threads in total. Main Thread is included.
        executorService.execute(ait);
        while (true) {
            int current = ait.getValue();
            if (current % 2 != 0) {
                System.out.println(current);
                System.exit(0);
            }
        }
    }
}
