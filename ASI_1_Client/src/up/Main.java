package up;

import up.DB.DBConnection;
import up.DB.DBOperation;
import up.testThread.StartTikTak;
import up.testThread.TestThread;
import up.testThread.TikTak;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
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

//        TestThread test = new TestThread(5);
//        TikTak tikTak = new TikTak();
//
//        StartTikTak t1 = new StartTikTak("Tik", tikTak);
//        StartTikTak t2 = new StartTikTak("Tak", tikTak);
//        StartTikTak t3 = new StartTikTak("Zak", tikTak);
//        test.startRunnable();
//        test.startCallable();
        DBConnection conn = new DBConnection();
//        Connection c = conn.connectToSQLite();
        try {
            Connection c = conn.connectToMySql();

//            conn.createTable();
            DBOperation operatio = new DBOperation(c);
//            operatio.insertPersonProc("Jan", "Nowak", 26);
            operatio.getCountPersonProc();
            operatio.getAllPersonProc();
//            operatio.insertPerson("Patryk", "Mazurek", 33);
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Zakńczenie głównego wątka");
    }
}
