package up;

import up.testThread.StartTikTak;
import up.testThread.TestThread;
import up.testThread.TikTak;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[] tabInt;
    public static List<Integer> numberList;

    public static void main(String[] args) {
	// write your code here

        numberList = new ArrayList<>();

        tabInt = new int[200];
        for (int i = 0;i<200;i++){
            tabInt[i] = -1;
         }

//        Client c = new Client("localhost", 5501);
//        c.connect();
//        c.sendMessage();
//        c.disconnect();
        //
//        FileClient fc = new FileClient("localhost", 5501, "pliki\\");
//        fc.connect();
//        fc.sendFileToServer();
//        fc.disconnect();
        // klasa odpowiadająca za pakowanie i roapakowywanie plików ZIP
//        packageZIP pz = new packageZIP();
//        File[] files = Path.of("pliki").toFile().listFiles();
////        pz.createArchive(files, "plik.zip");
//        pz.unpackageArchive(Path.of("pliki_out"), "plik.zip");

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i<20; i++){
                    System.out.println("wartość " + i);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        th.start();

//        try {
//            th.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        TestThread test = new TestThread(5);
        TikTak tikTak = new TikTak();

        StartTikTak t1 = new StartTikTak("Tik", tikTak);
        StartTikTak t2 = new StartTikTak("Tak", tikTak);
        StartTikTak t3 = new StartTikTak("Zak", tikTak);
//        test.startRunnable();
//        test.startCallable();
        System.out.println("Zakńczenie głównego wątka");
    }
}
