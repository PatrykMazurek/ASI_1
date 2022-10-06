package up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;
    private Socket socket;

    public Server(int port){
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                System.out.println("Oczekuje na klienta ...");
                socket = serverSocket.accept();
                System.out.println("Nawiązano połączenie z klientem ");
                clientConnection();
                cloesSocket();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clientConnection(){
        try {
            String text;
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(),
                            StandardCharsets.UTF_8));
            System.out.println("Oczekuje na wiadomość");
            while (true){
                writer.println("Witaj podaj imię lub dowolny tekst");
                writer.flush();
                text = reader.readLine();
                if (text.equals("e")){
                    System.out.println("Klient kończy połączenie ");
                    writer.close();
                    reader.close();
                    break;
                }
                System.out.println(text);
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
