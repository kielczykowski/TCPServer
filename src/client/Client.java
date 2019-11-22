package client;
import java.io.*;
import java.net.*;
import java.util.*;
import data.Person;

public class Client {
	ArrayList<Person> received;
	Socket socket;
	PrintWriter output;
	BufferedReader input;
	BufferedReader stdInput;
	
	public Client(String host, int port) throws Exception{
		this.received = new ArrayList<Person>();
		this.socket = new Socket(host,port);
		this.output = new PrintWriter(this.socket.getOutputStream(),true);
		this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.stdInput = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void run() throws Exception{
		String line, incoming;
		String [] splitted = new String[8];
		boolean decision= true;
		while(decision) {
			if((line = this.stdInput.readLine()) != null) {
				if(line.contentEquals("q")) {
					decision = !decision;
				}
				else {
					System.out.println("Client sent: " + line);
				}
				this.output.println(line);
			}
			if((incoming = this.input.readLine()) != null) {
				if(!incoming.contentEquals("User with this id wasnt found")) {
					System.out.println(incoming);
					splitted = incoming.split(":");
					for(String s:splitted) {
						System.out.println(s);
					}
					received.add(new Person(splitted[7],splitted[1], splitted[3],Integer.parseInt(splitted[5])));
					System.out.println(this.received);
				}
				System.out.println("Client received: " + incoming);
			}
		}
		System.out.println("Closing Client");
		this.finalize();
	}
	
	public void save(String path) throws Exception{
		Collections.sort(this.received);
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		for(Person person:this.received) {
			writer.write(person.toString() + "\n");
		}
		writer.close();
	}
	
	public void finalize() {
		try {
			this.socket.close();
			this.save("output.txt");
		} catch (Exception e) {
			System.out.println("Error closing client connection");
			System.err.println(e);
		}
	}

	
	public static void main(String [] args) {
		try {
			Client client = new Client("localhost",8080);
			client.run();
		}catch (Exception e) {
			System.err.println(e);
		}
	}
}
