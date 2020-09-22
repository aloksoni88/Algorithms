/**
 * 
 */
package com.alok.algoexpert.io.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author Alok Soni
 *
 */
public class ShortenPath {
	public static void main(String[] args) {
		String path = "/foo/../test/../test/../foo//bar/./baz";
		String shortPath = shortenPath(path);
		System.out.println(shortPath);
	}

	// Time - O(n)
	// Space - O(n) where n is the length of path
	public static String shortenPath(String path) {
		if (path == null || path.isEmpty()) {
			return "";
		}
		boolean isStartWithRootPath = path.startsWith("/") ? true : false;
		String[] tokens = path.split("/");
		List<String> tokenList = Arrays.asList(tokens);
		List<String> filteredTokenList = tokenList.stream().filter(token -> isImprotantToken(token))
				.collect(Collectors.toList());
		Stack<String> stack = new Stack<>();
		if (isStartWithRootPath) {
			stack.add("");
		}
		for (String token : filteredTokenList) {
			if (token.equals("..")) {
				if (stack.size() == 0 || stack.peek().equals("..")) {
					stack.add(token);
				} else if (!stack.peek().equals("")) {
					stack.pop();
				}
			} else {
				stack.add(token);
			}
		}
		if (stack.size() == 1 && stack.peek().equals("")) {
			return "/";
		} else {
			return String.join("/", stack);
		}
	}

	private static boolean isImprotantToken(String token) {
		return token.length() > 0 && !token.equals(".");
	}
}
