package up;

import up.testThread.TestThread;

import java.io.File;
import java.nio.file.Path;

public class Main {

    public static int[] tabInt;

    public static void main(String[] args) {
	// write your code here

        tabInt = new int[200];
        for (int i = 0;i<200;i++){
            tabInt[i] = -1;
         }

        Client c = new Client("localhost", 5501);
        c.connect();
        c.sendMessage();
        c.disconnect();
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
//        TestThread test = new TestThread(10);
//        test.startRunnable();
//        System.out.println("Zakńczenie głównego wątka");
    }
}
