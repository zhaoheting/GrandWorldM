package web.services.learn.multiThread.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource {
    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //We must create a server socket firstly that is bound with 8080 before we create
        //a socket to get input stream.
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream inputStream = new Socket("localhost", 8080).getInputStream();
        executorService.execute(new IOBlocked(inputStream));
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("start to close inputStream.");
        inputStream.close();
        System.out.println("Closed inputStream.");
    }
}
