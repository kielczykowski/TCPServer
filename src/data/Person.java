package data;

public class Person implements Comparable {
	String id, name, surname;
	int age;
	
	public Person(String id, String name, String surname, int age){
		this.age = age;
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	public String getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return "name:" + this.name + ":surname:" + this.surname + ":age:" + this.age + ":id:" + this.id + ":";
	}
	@Override
	public int compareTo(Object obj) {
		return this.age - ((Person)obj).age;
	}
	
public static void main (String args[]) {
	System.out.println("Person Mock test\nCreating Person");
	Person test = new Person("123456789","Michał","Kielonowski",22);
	System.out.println(test);
	System.out.println("Test ended");
}

}
