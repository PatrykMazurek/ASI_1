package up.testThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestThread {

    private int numberThread;

    public TestThread(int nth){
        numberThread = nth;
    }

    public void startRunnable() {

//        ExecutorService service = Executors.newCachedThreadPool();
        ExecutorService service = Executors.newFixedThreadPool(numberThread);
        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) service;

        int number = 0;
        while (number <= 200){
            if (threadPool.getActiveCount() < numberThread) {
                service.submit(new TestRunnable(number));
                number++;
            }
        }
        service.shutdown();
    }
}
