package com.alok.java8;

import java.io.IOException;

public class ShellExecuter {
	public static void main(String[] args) {
		try {
			System.out.println("done");
			Runtime.getRuntime().exec("adb shell input tap 560 2065");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
