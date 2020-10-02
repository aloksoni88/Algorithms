import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random(0);

		int n = Integer.parseInt(sc.nextLine());
		String[] a = new String[n];

		for (int i = 0; i < n; i++)
			a[i] = sc.nextLine();

		MyList obj = new ArrayToList();

		obj.convert(a);
		//int x = rand.nextInt(n);
		int x = 2;
		System.out.println("x = " + x);
		for (int i = 0; i < x; i++)
			obj.replace(rand.nextInt(n));

		ArrayList<String> s = obj.compact();
		System.out.println(s);
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).charAt(0) >= 97 && s.get(i).charAt(0) <= 122) {
				try {
					throw new InvalidStringException("This is an invalid string");
				} catch (InvalidStringException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}
}

class InvalidStringException extends Exception {
	public InvalidStringException() {
		super();
	}

	public InvalidStringException(String str) {
		super(str);
	}
}

interface MyList {
	void convert(String[] a);

	void replace(int idx);

	ArrayList<String> compact();
}

class ArrayToList implements MyList{
	ArrayList<String> arrayToList;
	
	public ArrayToList() {
		arrayToList = new ArrayList<>();
	}

	@Override
	public void convert(String[] a) {
		if(a == null) {
			return;
		}
		for(int i=0; i<a.length; i++) {
			arrayToList.add(a[i]);
			System.out.println("I have added the string:" + a[i] + " at index:" + i);
		}
	}

	@Override
	public void replace(int idx) {
		if(idx >= arrayToList.size()) {
			return;
		}
		String replacedString = arrayToList.get(idx);
		arrayToList.set(idx, null);
		System.out.println("I have replaced the string: " + replacedString +" with null string");
	}

	@Override
	public ArrayList<String> compact() {
		if(arrayToList != null && !arrayToList.isEmpty()) {
//			for(int i=0; i<arrayToList.size(); i++) {
//				if(arrayToList.get(i).isEmpty()) {
//					arrayToList.remove(i);
//				}
//			}
			while(arrayToList.remove(null)) {
				
			}
		}
		return arrayToList;
	}
	
}
