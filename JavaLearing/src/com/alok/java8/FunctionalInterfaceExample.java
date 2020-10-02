package com.alok.java8;

@FunctionalInterface 
interface Sayable2{  
    void say(String msg);  
    
    int hashCode();
    
    String toString();
    
} 


public class FunctionalInterfaceExample implements Sayable2{
	
	@Override
	public void say(String msg){  
        System.out.println(msg);  
    }  

	
    public static void main(String[] args) {  
    	FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
        fie.say("Hello there");  
    }
}