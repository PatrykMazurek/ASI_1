package up;

import up.DB.DBConnection;
import up.DB.DBOperation;
import up.server.SicretInfo;
import up.server.UDPClient;
import up.testThread.StartTikTak;
import up.testThread.TestThread;
import up.testThread.TikTak;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
//        DBConnection conn = new DBConnection();
////        Connection c = conn.connectToSQLite();
//        try {
//            Connection c = conn.connectToMySql();
//
////            conn.createTable();
//            DBOperation operatio = new DBOperation(c);
////            operatio.insertPersonProc("Jan", "Nowak", 26);
//            operatio.getCountPersonProc();
//            operatio.getAllPersonProc();
////            operatio.insertPerson("Patryk", "Mazurek", 33);
//            conn.disconnect();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        UDPClient udpClient = new UDPClient();
//        for (int i = 0; i<15; i++){
//            udpClient.sendMessage(i+"");
//        }
//        udpClient.sendMessage("end");
//        udpClient.close();

        BoardGame bg = new BoardGame();
        List<BoardGame> boardGameList = bg.initListGame();

        Supplier<Stream<BoardGame>> stream = () -> boardGameList.stream();
        Map<Integer, List<BoardGame>> tempList = boardGameList.stream()
                .filter(g -> g.name.contains("g"))
                .filter(g -> g.minPlayers > 1)
                .filter(g -> g.price < 50)
                .collect(Collectors.groupingBy(BoardGame::getYear));

        BoardGame game = boardGameList.stream()
                .filter(g -> g.price > 80)
                .findFirst()
                .orElse(null);

        if (game != null){
            System.out.println(game.name);
        }

        boardGameList.stream()
                .filter(g->g.price>100)
                .sorted(Comparator.comparing(BoardGame::getYear))
                .forEach(System.out::println);

        int warunek = 2010;

        Predicate<BoardGame> find = g -> g.year == warunek;

        SicretInfo si = new SicretInfo();
        byte[] tempMessage = si.encryptMessage("Dowolna wiadomość");
        System.out.println("Szyfrowanie wiadomości");
        String msg = new String(tempMessage);
        System.out.println("Wiadomosć " + msg);
        String deMessage = si.decryptMessage(tempMessage);
        System.out.println("Wiadomosć po odszyfrowaniu " + deMessage);

        System.out.println("Zakńczenie głównego wątka");
    }
}
