package com.alok.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExpression {
	public static void main(String[] args) {
		List<Item> list=new ArrayList<Item>();  
		
        list.add(new Item(1,"Samsung A5",17000f));  
        list.add(new Item(3,"Iphone 6S",65000f));  
        list.add(new Item(2,"Sony Xperia",25000f));  
        list.add(new Item(4,"Nokia Lumia",15000f));  
        list.add(new Item(5,"Redmi4 ",26000f));  
        list.add(new Item(6,"Lenevo Vibe",19000f));  
          
        // using lambda to filter data  
        Stream<Item> filtered_data = list.stream().filter(p -> p.price > 20000);
        
        List<Float> filteredList = list.stream()
        			.filter(p -> p.price > 20000)
        			.map(item -> item.price)
        			.collect(Collectors.toList());
       
        
        Map<Integer, Float> map = list.stream().collect(Collectors.toMap(Item:: getId, Item:: getPrice));
        Map<Integer, Float> map2 = list.stream().collect(Collectors.toMap(x -> x.getId(), y-> y.getPrice()));
        System.out.println(map);
        System.out.println(map2);
        
        final float[] max = {Float.MIN_VALUE};
        int[] maxValueKey = {-1};
        map.forEach((k,v) ->{
        	if(v > max[0]) {
        		max[0] = v;
        		maxValueKey[0] = k;
        	}
        	System.out.println(k + " " +v);
        });
        System.out.println("Max price is " + map.get(maxValueKey[0]));
        
        int count = (int) list.stream().filter(p->p.price >= 65000f).map(item -> item.price).count();
        System.out.println(count);
        
        System.out.println(filteredList);
          
        // using lambda to iterate through collection  
        filtered_data.forEach(  
                product -> System.out.println(product.name+": "+product.price)  
        );  
        
        
	}
}

class Item{  
    int id;  
    String name;  
    float price;  
    public Item(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}  
	
	@Override
	public String toString() {
		return id +", "+ name + ", " + price;
	}
    
    
}  
