package com.alok.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamAPI {
	public static void main(String[] args) {
		Integer[] arr= {0,1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,1,0};
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
		//System.out.println(list);
		list = (ArrayList<Integer>) list.stream().filter(val -> val == 1).collect(Collectors.toList());
		
		Stream<Integer> stream = Arrays.stream(arr);
		
		System.out.println(list);
		
		Path path = Paths.get("input.txt");
		try {
			Stream<String> streamOfStrings = Files.lines(path);
			Stream<String> streamWithCharset = 
					Files.lines(path, Charset.forName("UTF-8"));
			for(String str : streamOfStrings.collect(Collectors.toList())) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
				  new Product(14, "orange"), new Product(13, "lemon"),
				  new Product(23, "bread"), new Product(13, "sugar"));
		System.out.println(productList);
		
		Map<Integer, List<Product>> avgPrice = productList.stream().collect(Collectors.groupingBy(Product::getPrice));
		System.out.println(avgPrice);
		
	}
}

class Product{
	private int price;
	private String name;
	
	public Product(int price, String name) {
		this.price = price;
		this.name = name;
	}
	
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return name + "=" + price;
	}
}
