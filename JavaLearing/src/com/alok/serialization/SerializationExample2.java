package com.alok.serialization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample2 {

	public static void main(String[] args) {
		Emp emp = new Emp("ab", 20, 2, 1000);
		String fileName = "shubham.txt";

		// Serialization 
		Serialization serialization = new Serialization(emp, fileName);
		serialization.serializeObject();		

		// Deserialization 
		DeSerialization deSerialization = new DeSerialization();
		deSerialization.deSerializeObject(fileName);
	}
}

class Serialization {
	private Emp emp;
	private String fileName;
	public Serialization(Emp emp, String fileName) {
		this.emp = emp;
		this.fileName = fileName;
	}
	public void serializeObject() {
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(emp);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");
			System.out.println(emp);

			// value of static variable changed
			emp.b = 2000;
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}
}

class DeSerialization{
	public void deSerializeObject(String fileName) {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			Emp object = (Emp) in.readObject();

			in.close();
			file.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
			System.out.println(object);

			// System.out.println("z = " + object1.z);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
	}
}

class Emp implements Serializable {
	transient int a;
	static int b;
	String name;
	int age;

// Default constructor 
	public Emp(String name, int age, int a, int b) {
		this.name = name;
		this.age = age;
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age +", a=" + a +", b=" + b + "]";
	}
	
	

}
