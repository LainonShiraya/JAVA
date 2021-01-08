package knock;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {

	private Socket socket;
	
	public ServerThread(Socket socket) {
		
		super();
		this.socket = socket;

	}
	
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		

			String line1 = in.readLine();
			String line2 = in.readLine();

            System.out.println("Wczytalem: "+ line1 + line2);

            out.println("Server wyslal wiadomosc!");

		}catch( IOException el) {
			System.out.println(el);
		}
		
	}
}
