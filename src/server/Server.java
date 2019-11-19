package server;
import java.util.*;
import data.*;

public class Server {
	PersonTree data;
	
	public Server(String path) {
		this.data = new PersonTree(path);
	}
	
//	public Server(Person[] people) {
//		this.data = new TreeSet<Person>();
//		for(Person person:people) {
//			this.data.add(person);
//		}
//	}
	
	
	public static void main(String args[]) {
//		Person[] prs = {new Person("XD","XD","Dd",85123),new Person("D","XD","Dd",13), new Person("XsssD","XsD","Dd",123)};
//		Server srv2 = new Server(prs);
//		System.out.println(srv2.data.size());
//		for(Person pr: srv2.data)
//			System.out.println(pr);
	}
}
