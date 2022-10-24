package up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;
    private List<Socket> clientList;

    public Server(int port){
        try {
            ExecutorService service = Executors.newCachedThreadPool();
            clientList = new ArrayList<>();
            serverSocket = new ServerSocket(port);
            while (true){
                System.out.println("Oczekuje na klienta ...");
                socket = serverSocket.accept();
                System.out.println("Nawiązano połączenie z klientem ");
                clientList.add(socket);
                service.submit(new ServerThread(socket));
//                cloesSocket();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cloesSocket(){
        if (!socket.isClosed()){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
