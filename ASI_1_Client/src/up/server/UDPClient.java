package up.server;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClient {

    private DatagramPacket packet;
    private DatagramSocket socket;

    public UDPClient(){
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        byte[] buffOut = msg.getBytes(StandardCharsets.UTF_8);
        byte[] buffIn = new byte[512];
        try {
            InetAddress address = InetAddress.getLocalHost();
            int port = 5501;
            packet = new DatagramPacket(buffOut, buffOut.length, address, port);
            socket.send(packet);
            DatagramPacket packetIn = new DatagramPacket(buffIn, buffIn.length);
            socket.receive(packetIn);
            String message = new String(packetIn.getData(), 0,
                    packetIn.getLength(),
                    StandardCharsets.UTF_8);
            System.out.println(message);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){ socket.close(); }
}
