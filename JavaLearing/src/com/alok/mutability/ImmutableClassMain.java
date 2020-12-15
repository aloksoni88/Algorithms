package com.alok.mutability;

import java.util.HashMap;
import java.util.WeakHashMap;

public class ImmutableClassMain {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "abc");
		map.put(2, "xyz");
		
		
		ImmutableClassExample ice = ImmutableClassExample.createInstance("Alok", map);
		
		System.out.println(ice.getName());
		System.out.println(ice.getMap());
		map.put(2, "ssdfkjsdlfj");
		ice = ImmutableClassExample.createInstance("Alok", map);
		
		
		
		String s = ice.getMap().put(2, "salfjls");
		System.out.println(ice.getName());
		System.out.println(ice.getMap());
		
		
	}
}
