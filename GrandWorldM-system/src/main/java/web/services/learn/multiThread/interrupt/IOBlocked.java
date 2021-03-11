package web.services.learn.multiThread.interrupt;

import java.io.IOException;
import java.io.InputStream;

public class IOBlocked implements Runnable {
    InputStream is;

    public IOBlocked(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("IOBlocked is waiting for running.");
            //IO和在synchronized块上的等待是不可中断的。
            //此线程因为正在等待input，所以是阻塞状态
            is.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("IOBlocked is interrupted.");
            } else {
                e.printStackTrace();
            }
            System.out.println("Exit run method of IOBlocked .");
        }
    }
}
