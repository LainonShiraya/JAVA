package knock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Client  {
	
	private int port;

	public Client(int port) {
		this.port = port;
		try {
	     //   DatagramSocket socket = new DatagramSocket();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
		
	 public static void main(String[] argv)  {
			 int ports[] = {9999,9998};
			 System.out.println(ports.length);		
try {
	 		for(int y=0;y<ports.length;y++) {
	 			System.out.println(y);
	        DatagramSocket socket = new DatagramSocket();
	        InetAddress address = InetAddress.getLocalHost();
	        int port=ports[y];
	        System.out.println("Połączenie: "+address);	        
	        byte[] sendingDataBuffer = "20375".getBytes();
	        byte[] receivingDataBuffer = new byte[1024];
	        String message = "192.168.56.1:"+port;
	        DatagramPacket outgoingPacket2 = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,address,port);
	        socket.send(outgoingPacket2);
	        	   
	      String  sent = new String(outgoingPacket2.getData(),0,outgoingPacket2.getLength());
	  

	        DatagramPacket incomingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
	        socket.receive(incomingPacket);

	        String reply = new String(incomingPacket.getData(),0,incomingPacket.getLength());
	
	        
	        	Socket TCP = new Socket();
	        	TCP.connect(new InetSocketAddress("192.168.56.1",Integer.parseInt(reply)));
	        	PrintWriter out = new PrintWriter(TCP.getOutputStream(),true);
	    		BufferedReader in = new BufferedReader(new InputStreamReader(TCP.getInputStream()));
	    		
	    		out.println("Wiadomosc od Clienta z portu: "+reply);
	    		
	    		out.flush();
	    		out.println();
	    		

	    		String line;
	    		
	    		while((line = in.readLine()) != null && !line.isEmpty()) {
	    			System.out.println("Wiadomosc od servera: "+line);
	    		}

	       // socket.close();
}
}
catch(Exception e) {
	e.printStackTrace();
}

	 }




}