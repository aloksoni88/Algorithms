package com.alok.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSort {
	public static void main(String[] args) {
		Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        
        unsortMap.entrySet()
            	.stream()
            	.sorted(Map.Entry.comparingByValue())
            	.forEach(System.out::print);
        
        
        Map<String, Integer> map = unsortMap.entrySet()
        	.stream()
        	.sorted(Map.Entry.comparingByValue())       	
        	.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry:: getValue,
        			(item1, item2) -> item2, LinkedHashMap::new));
        System.out.println(map);
        

	}
}
