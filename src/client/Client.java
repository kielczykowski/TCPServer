package client;
import java.io.*;
import java.net.*;
import java.util.*;
import data.Person;

public class Client {

	
	public static void main(String [] args) {
		try {
			Socket socket = new Socket("localhost",8080);
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("XD");
			String line, income;
			boolean decision= true;
			while(decision) {
				if((line = stdIn.readLine()) != null) {
					if(line.contentEquals("q")) {
						decision = !decision;
					}
					else {
						System.out.println("Client sent: " + line);
					}
					out.println(line);
				}
				if((income = in.readLine()) != null) {
					System.out.println("Client received: " + income);
				}
			}
			socket.close();
			System.out.println("CLIENT ACTIONS ENDED");
		}catch (Exception e) {
			System.err.println(e);
		}
	}
}
