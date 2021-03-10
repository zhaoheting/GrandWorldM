package web.services.learn.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution implements Runnable {

    private SharedResource sharedResource;
    public Solution(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while(true){
            sharedResource.printThreadName();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        SharedResource sharedResource = new SharedResource();
        es.execute(new Solution(sharedResource));
        es.execute(new Solution(sharedResource));
        es.shutdown();
    }
}
