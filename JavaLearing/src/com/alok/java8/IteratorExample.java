package com.alok.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

//	    for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
//	    	System.out.println(iter.next());
//	        if (iter.next().equals("b")) {
//	             iter.remove();    // #1
//	             //list.remove("b"); // #2
//	        }
//	    }
	    
	    
	    //Iterator<String> it1 = list.iterator();
	    Iterator<String> it2 = list.iterator();
	    
//	    while(it2.hasNext()) {
//	    	if(it2.next().equals("b")) {
//	    		it2.remove();
//	    	}else {
//	    		System.out.println(it2.next());
//	    	}
//	    }
	    
	    for(String str : list) {
	    	System.out.println(str);
	    	if(str.equals("b")) {
	    		list.remove(str);
	    	}
	    }
	    
	}
}
