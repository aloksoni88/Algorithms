package com.alok.java8;

@FunctionalInterface
interface Sayable2{  
    void say(String msg);  
    
    int hashCode();
    
    String toString();
    
    
    default void test() {
    	System.out.println("test");
    }
    
    default void test2() {
    	System.out.println("test2");
    }
  
    
    static void staticFunction() {
    	System.out.println("static function");
    }
    
    static void staticFunction2() {
    	System.out.println("static function 2");
    }
    
    
} 


public class FunctionalInterfaceExample implements Sayable2{
	
	@Override
	public void say(String msg){  
        System.out.println(msg);  
    }  

	
    public static void main(String[] args) {  
    	FunctionalInterfaceExample fie = new FunctionalInterfaceExample();  
        fie.say("Hello there");  
        
        Sayable2 obj = (msg) ->{
        	System.out.println("calling functional interface directly");
        };
        obj.say("hello");
        
    }
    
}