package up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerThread implements Runnable{

    private Socket socket;

    public ServerThread(Socket s){
        socket = s;
    }

    @Override
    public void run() {
        clientConnection();
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
}
