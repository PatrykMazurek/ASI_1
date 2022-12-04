package up.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class UDPServer {

    private DatagramPacket packet;
    private DatagramSocket socket;

    public UDPServer(int port){
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void udpConnect(){
        byte[] byteIn = new byte[128];
        System.out.println("Oczekuje na połączenie ...");
        while (true){
            try {
                packet = new DatagramPacket(byteIn, byteIn.length);
                socket.receive(packet);
//                LocalDateTime time = LocalDateTime.now();
//                time.plusSeconds(45);
                String message = new String(packet.getData(), 0,
                        packet.getLength(),
                        StandardCharsets.UTF_8);
                System.out.println(message);
                String msgOut = "wiadomosć zwrotna " + message;
                packet.setData(msgOut.getBytes(StandardCharsets.UTF_8));
                if (message.equals("end")){
                    socket.send(packet);
                    break;
                }
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
