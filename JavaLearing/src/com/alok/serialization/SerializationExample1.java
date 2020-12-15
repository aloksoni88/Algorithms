package com.alok.serialization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample1 implements Serializable{
	public int a; 
    public String b; 
  
    // Default constructor 
    public SerializationExample1(int a, String b) 
    { 
        this.a = a; 
        this.b = b; 
    } 
    
	public static void main(String[] args) {
		SerializationExample1 object = new SerializationExample1(1, "geeksforgeeks");
		String filename = "file.ser";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(object);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		SerializationExample1 object1 = null;

		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			
			// Method for deserialization of object
			object1 = (SerializationExample1) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
			System.out.println("a = " + object1.a);
			System.out.println("b = " + object1.b);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}
}
