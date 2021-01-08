package knock;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ServerClass implements Runnable {


	private int port;
	private DatagramSocket serverSocket;
	static Socket client;



	public ServerClass(int port) {
		
		this.port = port;
		try {
			serverSocket = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		
		try {			
	          byte[] receiveData = new byte[1024];
	          byte[] sendData = new byte[1024];
	          while(true)
	             {
	                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	                serverSocket.receive(receivePacket);
	                System.out.println("koniec po receive");
	             //   String mess = new String(receiveData,0,receiveData.length);
	              //  System.out.println(mess);
	            //   String sentence = new String( receivePacket.getData());
	             //   System.out.println("Odebrano z server'a: " + sentence);
	                InetAddress IPAddress = receivePacket.getAddress();
	                int port = receivePacket.getPort();         
	    	    	 ServerSocket TCP = new ServerSocket(0);        
	                int capitalizedSentence = TCP.getLocalPort();
	    	        System.out.println("listening on port: " + TCP.getLocalPort());
	                sendData = String.valueOf(capitalizedSentence).getBytes();
	                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
	                serverSocket.send(sendPacket);
	            //   client = TCP.accept();
	           //  (new ServerThread(client)).start();
	                System.out.println("koniec while'a");
	                }
	    }
			
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
}
