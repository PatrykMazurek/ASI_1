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
//        randNumber();
        randNumberSync();
    }

    private synchronized void randNumber(){
        //        System.out.println("Wątek " + thId + " rozpoczoł pracę");
        Random rand = new Random();
        int number;
        boolean find = false;
        while (true){
            number = rand.nextInt(400);
//            for (int i = 0; i< Main.tabInt.length; i++){
//                if (Main.tabInt[i] == number){ find = true; }
//            }
            if (Main.numberList.contains(number)) { find = true;}
            if(!find){
                Main.tabInt[thId] = number;
                break;
            }
        }
        int w = rand.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + " zapisał do tabInt["+thId+"] = "
                + number);
//        System.out.println();
        try {
            Thread.sleep(w);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println("Wątek " + thId + " zakończył pracę");
    }

    private void randNumberSync(){
        Random rand = new Random();
        int number;
        boolean find = false;
        synchronized (this){
            while (true){
                number = rand.nextInt(400);
//            for (int i = 0; i< Main.tabInt.length; i++){
//                if (Main.tabInt[i] == number){ find = true; }
//            }
                if (Main.numberList.contains(number)) { find = true;}
                if(!find){
                    Main.tabInt[thId] = number;
                    break;
                }
            }
        }
        int w = rand.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + " zapisał do tabInt["+thId+"] = "
                + number);
//        System.out.println();
        try {
            Thread.sleep(w);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
