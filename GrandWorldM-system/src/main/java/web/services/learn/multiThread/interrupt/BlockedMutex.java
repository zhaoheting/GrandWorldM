package web.services.learn.multiThread.interrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex {
    Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
        System.out.println("Lock is occupied by the constructor.");
    }

    public void f() {
        try {
            lock.lockInterruptibly();
            System.out.println("Lock is occupied by method f().");
        } catch (InterruptedException e) {
            System.out.println("Method f() is interrupted.");
        } finally {
            try {
                //It's possible that the thread is interrupted before it get the lock, so a IllegalMonitorStateException
                //may be thrown out when the unlock method is called.
                //It means why to call the unlock method when the thread never call the lock method.
                lock.unlock();
            } catch (IllegalMonitorStateException e) {
                System.out.println("Thread failed to got the lock.");
            }

        }
    }

}
