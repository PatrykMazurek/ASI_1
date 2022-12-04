package up;

import up.server.UDPServer;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Server s = new Server(5501);
//        s.clientConnection();
        UDPServer udpServer = new UDPServer(5501);
        udpServer.udpConnect();
//        FileServer fs = new FileServer(5501, "pliki_server\\");
//        fs.clientConnection();

    }
}
