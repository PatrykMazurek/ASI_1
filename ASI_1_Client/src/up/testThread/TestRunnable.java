package up.testThread;

import up.Main;

import java.util.Random;

public class TestRunnable implements Runnable{

    private int thId;

    public TestRunnable(int th){
        thId = th;
    }

    @Override
    public void run() {
//        System.out.println("Wątek " + thId + " rozpoczoł pracę");
        Random rand = new Random();
        int id = rand.nextInt(200);
        Main.tabInt[id] = thId;
        int w = rand.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + " zapisał do tabInt["+id+"]");
//        System.out.println();
        try {
            Thread.sleep(w);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Wątek " + thId + " zakończył pracę");
    }
}
