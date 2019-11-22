package server;
import java.util.*;
import data.*;
import java.net.*;
import java.io.*;

public class Server {
	PersonTree data;
	ServerSocket server;
	PrintWriter output;
	BufferedReader input;
	
	public Server(String path) throws Exception{
		System.out.println("Starting server");
		this.data = new PersonTree(path);
		this.server = new ServerSocket(8080);
		System.out.println("Waiting for connection");
		Socket cs = this.server.accept();
		System.out.println("Connection established");
		this.output = new PrintWriter(cs.getOutputStream(),true);
		this.input = new BufferedReader(new InputStreamReader(cs.getInputStream()));
	}
	public void run() throws Exception{
		String inl, outl;
		outl = "Napisz cos ['q' konczy wymianę]";
		while((inl = this.input.readLine()) != null) {
			if(inl.contentEquals("q")) break;
			System.out.println(inl);
			this.output.println(outl);
		}
		System.out.println("out");
		this.finalize();
	}
	
	@Override
	public void finalize(){
		try {
			System.out.println("Closing server");
			this.server.close();
		} catch (Exception e) {
			System.out.println("Exception during server closure ocurred:");
			System.err.println(e);
		}
		System.out.println("finalizing");
	}
//	public Server(Person[] people) {
//		this.data = new TreeSet<Person>();
//		for(Person person:people) {
//			this.data.add(person);
//		}
//	}
	
	
	public static void main(String args[]) {
		System.out.println("SYSTEM START");
		try {
			Server srv = new Server("/home/michal/Programming/TCPServer/src/data/data");
			srv.run();
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println("SERVER END");
	}
}
