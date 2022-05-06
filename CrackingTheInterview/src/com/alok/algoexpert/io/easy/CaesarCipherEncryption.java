/**
 * 
 */
package com.alok.algoexpert.io.easy;

/**
 * @author Alok Soni
 *
 */
public class CaesarCipherEncryption {
	public static void main(String[] args) {
		String str = "abc";
		int key = 31;
//		String result = caesarCypherEncryptor(str, key);
		String result = encryption(str, key);
		System.out.println(result);
	}

	public static String caesarCypherEncryptor(String str, int key) {
		char[] c = str.toCharArray();
		String result = "";
		key = key % 26;
		for (int i = 0; i < c.length; i++) {
			if ((c[i] + key) > 122) {
				char value = (char) (96 + (c[i] - 122 + key));
				result = result + value;
			} else {
				char value = (char) (c[i] + key);
				result = result + value;
			}
		}
		return result;
	}
	
	public static String encryption(String str, int key){
		char[] chArr = str.toCharArray();
		int keyValue = key % 26;
		StringBuffer buffer = new StringBuffer("");
		for(int i=0; i<str.length(); i++){
			if(chArr[i] + keyValue > 122){
				char c = (char)((chArr[i] + keyValue) - 122 + 96);
				buffer.append(c);
			}else{
				char c = (char)(chArr[i] + keyValue);
				buffer.append(c);
			}
		}
		return buffer.toString();
	}

}
