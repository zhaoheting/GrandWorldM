package web.services.learn.multiThread.compareSynchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        PairManager pm1 = new PairManagerImpl1();
        PairManipulator manipulator1 = new PairManipulator(pm1);
        PairChecker pairChecker1 = new PairChecker(pm1);

        PairManager pm2 = new PairManagerImpl2();
        PairManipulator manipulator2 = new PairManipulator(pm2);
        PairChecker pairChecker2 = new PairChecker(pm2);

        PairManager pm3 = new PairManagerLockImpl1();
        PairManipulator manipulator3 = new PairManipulator(pm3);
        PairChecker pairChecker3 = new PairChecker(pm3);

        PairManager pm4 = new PairManagerLockImpl1();
        PairManipulator manipulator4 = new PairManipulator(pm4);
        PairChecker pairChecker4 = new PairChecker(pm4);

        executorService.execute(manipulator1);
        executorService.execute(pairChecker1);
        executorService.execute(manipulator2);
        executorService.execute(pairChecker2);

        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println(manipulator1);
        System.out.println(manipulator2);

        executorService.execute(manipulator3);
        executorService.execute(pairChecker3);
        executorService.execute(manipulator4);
        executorService.execute(pairChecker4);
        TimeUnit.MILLISECONDS.sleep(5000);

        System.out.println(manipulator3);
        System.out.println(manipulator4);
        System.exit(0);
    }
}
