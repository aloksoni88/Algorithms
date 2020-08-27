package com.alok.mutability;

import java.util.HashMap;

public final class ImmutableClassExample {
	private final String name;
	private final HashMap<Integer, String> map;
	
	private ImmutableClassExample(String name, HashMap<Integer, String> map) {
		this.name = name;
		this.map = map;
	}
	
	public static ImmutableClassExample createInstance(String name, HashMap<Integer, String> map) {
		return new ImmutableClassExample(name, map);
	}
	
	public String getName() {
		return name;
	}
	
	public HashMap<Integer, String> getMap() {
		return (HashMap<Integer, String>) map.clone();
		//return (Date) date.clone();
	}

}

