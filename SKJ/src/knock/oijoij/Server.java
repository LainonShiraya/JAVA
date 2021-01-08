package knock.oijoij;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
   private static int ports[]=new int[]{10001,10003,10004};


    public static void main(String[] args) {
        System.out.println("|||||||SERVER|||||||");
        for (int i = 0; i < ports.length; i++) {
            try {
                ServerClass serverClass=new ServerClass(ports[i]);
                Thread serverClassThread= new Thread(serverClass);
                serverClassThread.run();
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }

    }

}

class ServerClass implements Runnable{
    private int port;
    private DatagramSocket paket;
    private byte[] buffer;

    public ServerClass(int port) throws SocketException {
        this.port = port;
        paket=new DatagramSocket(port);
    }

    @Override
    public void run() {
        try {

            buffer=new byte[65000];
            DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);
            paket.receive(datagramPacket);
            String mess=new String(buffer,0,buffer.length);
            System.out.println(mess);
        } catch (SocketException e) {
            e.printStackTrace();
            Thread.currentThread().stop();
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().stop();
        }

    }


}