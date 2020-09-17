package web.services.learn.lessons;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 网上找的测试代码。
 */
public class LockFreeThreadSafeQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //创建线程池
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        //实例化队列
        LockFreeThreadSafeQueue<String> queue = new LockFreeThreadSafeQueue<String>();
        //该map用于检查该队列是否是线程安全的，利用其key不能重复来判断
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
        //随机数
        Random random = new Random(System.currentTimeMillis());

        //创建5个写runnable
        IntStream.range(0, 5).boxed().map(i -> (Runnable) () -> {
            int count = 0;
            //每个runnable往队列插入10个元素
            while (count++ < 10) {
                //这里值用系统的纳秒+随机数+count，以防止重复影响map集合对队列线程安全的判断
                queue.enqueue(System.nanoTime() + ":" + random.nextInt(10000) + ":" + count);
            }
            //提交任务
        }).forEach(threadPool::submit);
        //创建5个读runnable
        IntStream.range(0, 5).boxed().map(i -> (Runnable) () -> {
            int count = 10;
            //每个runnable读10个元素
            while (count-- > 0) {
                //休眠
                try {
                    TimeUnit.MILLISECONDS.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //移除队列中的队首元素
                String result = queue.dequeue();
                //输出
                System.out.println(result);
                //将该元素加入map中，来判断队列中真实存入的元素个数
                map.put(result, new Object());
            }
            //提交任务
        }).forEach(threadPool::submit);

        //关闭线程池
        threadPool.shutdown();
        //等待1小时候强制关闭线程池
        threadPool.awaitTermination(1, TimeUnit.HOURS);
        //打印map中的元素个数
        System.out.println(map.size());
    }
}
