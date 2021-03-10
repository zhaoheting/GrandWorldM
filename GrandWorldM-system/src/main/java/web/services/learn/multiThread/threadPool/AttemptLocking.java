package web.services.learn.multiThread.threadPool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock() will try to get the lock again when it failed at current time.
 * tryLock() will try to get the lock for only one time, it will continue to run the next line if it failed and it will not try again.
 * tryLock(time,TimeUnit) will try to get the lock again during the designated time interval when it failed.
 */
public class AttemptLocking {
    Lock lock = new ReentrantLock();

    private void timed() {
        boolean isLocked = lock.tryLock();
        try {
            System.out.println("Timed is running.");
        } finally {
            if (isLocked) {
                System.out.println("The lock has been acquired and then unlocked.");
                lock.unlock();
            } else {
                System.out.println("Timed is running. But the lock hasn't been acquired.");
            }
        }
    }

    private void unTimed() {
        boolean isLocked = false;
        try {
            isLocked = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("UnTimed is running.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (isLocked) {
                lock.unlock();
                System.out.println("The unLock has been acquired and then unlocked.");
            } else {
                System.out.println("UnTimed is running. But the lock hasn't been acquired.");
            }
        }
    }

    public static void main(String[] args) {
        AttemptLocking al = new AttemptLocking();
        al.timed();
        al.unTimed();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                al.lock.lock();
                try {
                    System.out.println("The daemon thread is running.");
                } finally {
                    System.out.println("Damon is unlocked.");
                }
            }
        }.start();
        Thread.yield();
        al.timed();
        al.unTimed();
    }
}
