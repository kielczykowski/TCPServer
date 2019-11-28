package data;
import java.io.*;
import java.util.*;

class Osoba implements Comparable, Serializable{
	String imie;
	String nazwisko;
	int wiek;
	static int liczbael;
	
	public int compareTo(Object o) {
		Osoba tmp;
		tmp = (Osoba)o;
		return this.wiek - tmp.wiek;
	}
	
	Osoba(String imie, String nazwisko, double wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = (int)wiek;
		liczbael +=1;
	}
	
}

public class Test2 {
	public static void main(String args[]) {
		Osoba mapa [];
		mapa = new Osoba[3];
		mapa[1] = new Osoba("Ania", "AAA", 1.0);
		mapa[2] = new Osoba("Tomek","TTT", 2.0);
		mapa[0] = new Osoba("Staszek","SSS",3.0);
		
		Arrays.sort(mapa);

		try {		
			FileOutputStream fs = new FileOutputStream("osoby.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(mapa);
			os.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Liczba elementow: " + Osoba.liczbael);
	}
	

}
