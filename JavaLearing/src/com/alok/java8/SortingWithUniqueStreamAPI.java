package com.alok.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortingWithUniqueStreamAPI {
	public static void main(String[] args) {
		ArrayList<UserTest> list = new ArrayList<>();
		list.add(new UserTest(2, "User3"));
		list.add(new UserTest(10, "User1"));
		list.add(new UserTest(3, "User1"));
		list.add(new UserTest(4, "User2"));
		
		List<UserTest> sortedList = list.stream()
					.sorted(Comparator.comparingInt(UserTest:: getId).reversed())					
					.filter(distinctByName(u -> u.getName()))
					.collect(Collectors.toList());
		System.out.println(sortedList);
	}
	
	
	private static <T> Predicate<T> distinctByName(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

class UserTest{
	private Integer id;
	private String name;
	
	
	public UserTest(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
		return "id=" + id + ", name=" + name + "\n";
	}
	
	
}
