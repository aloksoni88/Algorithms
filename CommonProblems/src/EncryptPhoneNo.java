

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class EncryptPhoneNo {
	public static void main(String[] args) {
		try {
			String text = "8377944971";
			//String key = "Bar12345Bar12345"; // 128 bit key
			String key = "BKN79364IOD29857"; // 128 bit key
			// Create key and cipher
			Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			// encrypt the text
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			byte[] encrypted = cipher.doFinal(text.getBytes());
			System.err.println(new String(encrypted));
			// decrypt the text
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			String decrypted = new String(cipher.doFinal(encrypted));
			System.err.println(decrypted);
			
			
			System.out.println(encodeBase62(2905));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String encodeBase62(long num) {
        try {
			String code = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String text = "";
			int j = (int)Math.ceil(Math.log(num)/Math.log(code.length()));
			for(int i = 0; i < j; i++){
			    //i goes to log base code.length() of num (using change of base formula)
			    text += code.charAt((int)(num%code.length()));
			    num /= code.length();
			}
			return text;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
