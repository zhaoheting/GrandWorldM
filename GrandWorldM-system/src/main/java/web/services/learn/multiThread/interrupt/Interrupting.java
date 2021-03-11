package web.services.learn.multiThread.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class Interrupting {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(new IOBlocked(System.in));
        print("interrupting.");
        //不能中断正在试图获取synchronized锁或者试图执行IO操作的线程，所以本方法将不能中断IOBlocked线程。
        future.cancel(true);
        print("interrupt sent.");
        TimeUnit.SECONDS.sleep(5);
        System.exit(0);
    }
}
