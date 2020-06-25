/**
 * 
 */
package com.alok.algoexpert.io;

/**
 * @author Alok Soni
 *
 */
public class CaesarCipherEncryption {
	public static void main(String[] args) {
		String str = "abc";
		int key = 3;
		String result = caesarCypherEncryptor(str, key);
		System.out.println(result);
	}
	public static String caesarCypherEncryptor(String str, int key) {
	    char[] c  = str.toCharArray();
		String result = "";
		key = key%26;
		for(int i=0; i<c.length; i++){
			if( (c[i] + key) > 122 ){
					char value = (char)(96 + (c[i] - 122 + key));
					result = result + value;
			}else{
					char value = (char) (c[i] + key);
					result = result + value;
			}
		}
	    return result;
	  }
}
