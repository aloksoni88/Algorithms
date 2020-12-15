package com.alok.serialization;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

public class DeserializationUtility {
	public static void main(String[] args) {
		 
        try {
			System.out.println("Deserializing AppleProduct...");
			String serializedObj = getFromFile("product.ser");
			SerializeProduct deserializedObj = (SerializeProduct) deSerializeObjectFromString(
			  serializedObj);
 
			System.out.println(
			  "Headphone port of AppleProduct:"
			    + deserializedObj.getHeadphonePort());
			System.out.println(
			  "Thunderbolt port of AppleProduct:"
			   + deserializedObj.getThunderboltPort());
			
			System.out.println(
					  "Lightening port of AppleProduct:"
					   + deserializedObj.getLighteningPort());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	public static SerializeProduct deSerializeObjectFromString(String s) throws IOException, ClassNotFoundException {

		byte[] data = Base64.getDecoder().decode(s);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		Object o = ois.readObject();
		ois.close();
		return (SerializeProduct) o;
	}
	
	private static String getFromFile(String fileName) {
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			String str = (String) in.readObject();

			in.close();
			file.close();
			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
			System.out.println(str);

			return str;
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException" + " is caught");
		}
		return null;
	}
}
