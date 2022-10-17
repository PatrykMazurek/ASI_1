package up;

import java.io.File;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
	// write your code here

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
        packageZIP pz = new packageZIP();
        File[] files = Path.of("pliki").toFile().listFiles();
//        pz.createArchive(files, "plik.zip");
        pz.unpackageArchive(Path.of("pliki_out"), "plik.zip");
    }
}
