package com.alok.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CollectorsExample {
	public static void main(String[] args) {
		List<Item> productsList = new ArrayList<Item>();
		// Adding Products
		productsList.add(new Item(1, "HP Laptop", 25000f));
		productsList.add(new Item(2, "Dell Laptop", 30000f));
		productsList.add(new Item(3, "Lenevo Laptop", 28000f));
		productsList.add(new Item(4, "Sony Laptop", 28000f));
		productsList.add(new Item(5, "Apple Laptop", 90000f));
		
		
		// fetching price list
		List<Float> productPriceList = productsList
				.stream()
				.filter(item -> item.price >= 30000)
				.map(x -> x.price) 
				.collect(Collectors.toList()); 
		System.out.println(productPriceList);
		
		//converting list to set
		Set<Float> set = productsList
				.stream()
				.map(item -> item.price)
				.collect(Collectors.toSet());
		System.out.println(set);
		
		//converting list to map
		Map<String, Float> map = productsList
				.stream()
				//.sorted(Comparator.comparing(item -> item.price))
				.collect(Collectors.toMap(item-> item.name, item -> item.price));
		System.out.println(map);
		
		//calculate total price
		Double totalPrice = productsList
				.stream()
				.collect(Collectors.summingDouble(item -> item.price));
		System.out.println(totalPrice);
		
		//getting average price
		Double avgPrice = productsList
				.stream()
				.collect(Collectors.averagingDouble(item -> item.price));		
		System.out.println(avgPrice);
		
		float totalP = productsList
				.stream()
				.map(item -> item.price)
				.reduce(0f, (sum, price) -> sum + price);
		System.out.println(totalP);
		
		Item minPrice = productsList
				.stream()
				.min((item1, item2)-> (item1.price > item2.price ? 1: -1)).get(); 
		System.out.println("Min price product" + minPrice);
		
		Item maxPrice = productsList
				.stream()
				.max((item1, item2)-> (item1.price > item2.price ? 1: -1)).get(); 
		System.out.println("Max price product" + maxPrice);
		
		List<Float> price = productsList
				.stream()
				.sorted(Comparator.comparing(Item:: getName))
				.map(item -> item.getPrice())
				.collect(Collectors.toList());
		System.out.println(price);

		
		
		String[] strings = {"abc", "xyz", "", "lsj", "", "", "1223"};
		ArrayList<String> strList = new ArrayList<>(Arrays.asList(strings));
		
		List<String> strListFiltered = strList
			.stream()
			.filter(str -> !str.isEmpty())
			.collect(Collectors.toList());
		System.out.println(strListFiltered);
	}
}
