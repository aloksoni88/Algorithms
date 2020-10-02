import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomException {
	static void validate(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("not valid");
		else
			System.out.println("welcome to vote");
	}
	
	static void arrayIndexing(int age) {
		try {
			int x = 1/0;
		}catch (ArithmeticException e) {
			new ArrayIndexOutOfBound(e);
		}
	}
	
	static void checkEmail(String email) throws InvalidEmailException {
		if(email == null || email.isEmpty() || !email.contains("@") || !email.contains(".com")){
			throw new InvalidEmailException(email);
		}else {
			System.out.println("Valid Email");
		}
	}

	public static void main(String args[]) {
		try {
			validate(13);
			//arrayIndexing(0);
		} catch (Exception m) {
			System.out.println("Exception occured: " + m);
		}
		
		try {
			checkEmail("alok@gmail");
		} catch (InvalidEmailException e1) {
			e1.printStackTrace();
		}
		
		FileOutputStream fos = null;
		try {
		    fos = new FileOutputStream(new File("may_not_exist.txt"));
		} catch (FileNotFoundException e) {
		    // ask the user and try again
		} catch (IOException e) {
		    // more serious, abort
		} finally {
		    if (fos!=null) { try { fos.close(); } catch (IOException e) { /*ignore*/ } }
		}

		System.out.println("rest of the code...");
	}
}

class InvalidAgeException extends Exception {
	InvalidAgeException(String s) {
		super(s);
	}
}

class ArrayIndexOutOfBound extends ArithmeticException{
	ArrayIndexOutOfBound(ArithmeticException e){
		System.out.println("Index out of bound exception");
		e.printStackTrace();
	}
}

class InvalidEmailException extends Exception{
	public InvalidEmailException(String invalidEmail) {
		super(invalidEmail);
	}
	
	public InvalidEmailException(Exception e) {
		System.out.println("Invalid email");
	}
}