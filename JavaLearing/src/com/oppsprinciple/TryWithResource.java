package com.oppsprinciple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResource {
	public static void main(String[] args) {
		
//		Scanner scanner = null;
//		try {
//		    scanner = new Scanner(new File("test.txt"));
//		    while (scanner.hasNext()) {
//		        System.out.println(scanner.nextLine());
//		    }
//		} catch (FileNotFoundException e) {
//		    e.printStackTrace();
//		} finally {
//		    if (scanner != null) {
//		        scanner.close();
//		    }
//		}
		
		//instead of above code
		try(Scanner scanner = new Scanner(new File("test.txt"))){
			while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
