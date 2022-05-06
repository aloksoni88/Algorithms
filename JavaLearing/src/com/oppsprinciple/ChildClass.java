package com.oppsprinciple;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ChildClass extends ParentClass{
	
	int SameMethodDiffReturnType() throws FileNotFoundException{
		return 10;
	}

	public static void main(String[] args) {
		System.out.println("Child class");
	}
}
