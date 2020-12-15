package com.alok.serialization;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class SerializationUtility {
	
	public static void main(String[] args) {
		
		SerializeProduct product = new SerializeProduct();
		product.setHeadphonePort("headphonePort2020");
		product.setThunderboltPort("thunderboltPort2020");

		String serializedObj = serializeObjectToString(product);

		System.out.println("Serialized AppleProduct object to string:");
		System.out.println(serializedObj);
	}

	public static String serializeObjectToString(Serializable o) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.close();

			String str = Base64.getEncoder().encodeToString(baos.toByteArray());
			saveToFile(str, "product.ser");
			return str;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void saveToFile(String str, String fileName) {
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(str);

			out.close();
			file.close();

			System.out.println("Object has been serialized\n" + "Data before Deserialization.");
			System.out.println(str);

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}
}