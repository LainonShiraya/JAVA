package knock.oijoij;



import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientManager {
    public static void main(String[] args) {
        int[] ports = new int[]{10001,10003,10004};
        for (int i = 0; i < ports.length; i++) {
//         ExecutorService executorService=Executors.newFixedThreadPool(1);
//         executorService.submit(new Client(ports[i]));
            Client client = new Client(ports[i]);
            Thread thread = new Thread(client);
            thread.start();
        }
    }
}


class Client implements Runnable {
    private final int port;
    private DatagramSocket datagramSocket;
    private byte[] buffer;

    public Client(int port) {
        this.port = port;
        try {
            datagramSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        buffer = new byte[65000];
        try {
            while (true) {
                String s = "20482";
                buffer = s.getBytes();
                DatagramPacket sent = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), port);
                datagramSocket.send(sent);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
