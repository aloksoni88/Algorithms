package com.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableNMap {
	public static void main(String[] args) {
		Hashtable<Integer,String> ht=new Hashtable<Integer,String>(); 
        ht.put(101," ajay"); 
        ht.put(101,"Vijay"); 
        ht.put(102,"Ravi"); 
        ht.put(103,"Rahul"); 
        ht.put(104,"");
        ht.put(105,"");
        System.out.println("-------------Hash table--------------"); 
        for (Map.Entry m:ht.entrySet()) { 
            System.out.println(m.getKey()+" "+m.getValue()); 
        } 
  
        //----------------hashmap-------------------------------- 
        HashMap<Integer,String> hm=new HashMap<Integer,String>(); 
        hm.put(100,"Amit"); 
        hm.put(104,"Amit");  // hash map allows duplicate values 
        hm.put(101,"Vijay"); 
        hm.put(102,"Rahul");
        hm.put(99, "lsdjflskdf");
        hm.put(90, "null");
        System.out.println("-----------Hash map-----------"); 
        for (Map.Entry m:hm.entrySet()) { 
            System.out.println(m.getKey()+" "+m.getValue()); 
        } 
	}
}
