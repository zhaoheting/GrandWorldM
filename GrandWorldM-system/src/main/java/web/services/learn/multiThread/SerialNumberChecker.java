package web.services.learn.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SerialNumberChecker implements Runnable {

    volatile CircularSet circularSet = new CircularSet(1000);

    @Override
    public void run() {
        while (true) {
            int current = SerialNumberGenerator.next();
            if (circularSet.contains(current)) {
                System.out.println(current + " has already exists.");
                System.exit(0);
            }
            circularSet.add(current);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; ++i) {
            executorService.execute(new SerialNumberChecker());
        }
        /**
         * The main thread will exit, if no exit signal is thrown out from any threads for designated args[0] time interval.
         */
        if (args.length != 0) {
            TimeUnit.SECONDS.sleep(Integer.valueOf(args[0]));
            System.out.println("No duplicates detected.");
            System.exit(0);
        }
    }
}
