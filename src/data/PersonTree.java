package data;
import java.util.*;
import java.io.*;

public class PersonTree{
	TreeSet<Person> data;
	
	public PersonTree(String path){
		this.data = new TreeSet<Person>();
		this.createFromFile(path);
	}
	
	void createFromFile(String path) {
		try {
			String buffer[];
			BufferedReader bi = new BufferedReader(new FileReader((path)));
			String line;
			while((line = bi.readLine()) != null) {
				buffer = line.split(" ");
				this.data.add(new Person(buffer[0],buffer[1],buffer[2],Integer.parseInt(buffer[3])));				
			}
			bi.close();
		}catch (Exception e) {
			System.err.println(e);
		}
		System.out.println(this.data);
	}
public static void main(String args []) {
	PersonTree pt = new PersonTree("/home/michal/Programming/TCPServer/src/data/data");
}
}
