package knock;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//static Socket client;

	
	
	public static void main(String args[]) throws Exception
    {
				
		 int ports[] = {9999,9998};

     //  DatagramSocket serverSocket = new DatagramSocket(9999);
       //   byte[] receiveData = new byte[1024];
        //  byte[] sendData = new byte[1024];
        
		for (int i=0; i< ports.length; i++) {
				
				ServerClass serverClass = new ServerClass(ports[i]);
				Thread serverClassThread = new Thread(serverClass);
				serverClassThread.run();
			//	serverClassThread.interrupt();
			//	client = TCP.accept();
	            //  (new ServerThread(client)).start();

		}
	
}
}


