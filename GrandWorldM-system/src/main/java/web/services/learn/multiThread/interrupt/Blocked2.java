package web.services.learn.multiThread.interrupt;

import java.util.concurrent.TimeUnit;

public class Blocked2 implements Runnable {
    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        blockedMutex.f();
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Blocked2());
        thread.start();
        thread.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Start to interrupt the thread.");
    }
}
