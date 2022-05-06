package com.oppsprinciple;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ParentClass {
	int SameMethodDiffReturnType() throws IOException {
		System.out.println("Parent Class method");
		return 10;
	}
}
