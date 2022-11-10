package up.testThread;

import up.Main;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<String> {


    private int thId;

    public TestCallable(int th){
        thId = th;
    }

    @Override
    public String call() throws Exception {
        return randNumber();
//        return null;

    }

    private String randNumber() {
        Random rand = new Random();
        int number;
        boolean find = false;
        while (true){
            number = rand.nextInt(400);
            if (Main.numberList.contains(number)) { find = true;}
            if(!find){
                Main.tabInt[thId] = number;
                break;
            }
            int w = rand.nextInt(5000);
            try {
                Thread.sleep(w);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String text = Thread.currentThread().getName() + " zapisał do tabInt["+thId+"] = "
                + number;
        return text;
    }


}
