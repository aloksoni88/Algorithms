package com.alok.java8;

 
public class MethodReference {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        Sayable sayable = MethodReference::saySomething; 
        // Calling interface method  
        sayable.show();
    }  
}  


interface Sayable{  
    void show();  
} 