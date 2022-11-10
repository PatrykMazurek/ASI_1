package up.testThread;

import up.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

    public void startCallable(){

        ExecutorService service = Executors.newFixedThreadPool(numberThread);
//        List<Future<String>> futureList = new ArrayList<>();
        BlockingDeque<Future<String>> futuresDeque = new LinkedBlockingDeque<>();
        System.out.println("Dowawanie zadań od listy");
        for (int i = 0; i < Main.tabInt.length; i++){
            TestCallable tc = new TestCallable(i);
            futuresDeque.add(service.submit(tc));
//            futureList.add(service.submit(tc));
        }
        System.out.println("odbieranie rezultatów");
        Future<String> f;
        while(!futuresDeque.isEmpty()){
            f = futuresDeque.poll();
            try {
                String text = f.get();
                System.out.println(text);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
//        for(int n = 0; n < futureList.size(); n++){
//            Future<String> f = futureList.get(n);
//            try {
//                String text = f.get(2, TimeUnit.SECONDS);
//                System.out.println(text);
//            } catch (InterruptedException | TimeoutException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        service.shutdown();

    }


}
