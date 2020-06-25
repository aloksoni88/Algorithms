package com.hashing;

import java.util.HashMap;
import java.util.HashSet;

public class EqualsNHashCode {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String,String>();
		hashMap.put("1", "abc");
		hashMap.put("1", "xyz");
		
		System.out.println("Hash map for String or Wrapper class");
		System.out.println(hashMap.size());
		System.out.println(hashMap);
		
		
		System.out.println();
		StuentWithoutEquNHash st1 = new StuentWithoutEquNHash(1, "Alok", 10);
		StuentWithoutEquNHash st2 = new StuentWithoutEquNHash(1, "Alok", 10);
		HashMap<StuentWithoutEquNHash, String> studentMapPlan = new HashMap<StuentWithoutEquNHash, String>();
		studentMapPlan.put(st1, "abc");
		studentMapPlan.put(st2, "xyz");
		
		System.out.println("Hash map of Student class which does not overides equlas and hashcode method");
		System.out.println(studentMapPlan.size());
		System.out.println(studentMapPlan);
		
		
		System.out.println();
		Student student1 = new Student(1, "Alok", 10);
		Student student2 = new Student(1, "Alok", 10);
		HashMap<Student, String> studentMap = new HashMap<Student, String>();
		studentMap.put(student1, "abc");
		studentMap.put(student2, "xyz");
		
		System.out.println("Hash map of Student class which overides equlas and hashcode method");
		System.out.println(studentMap.size());
		System.out.println(studentMap);
		
		System.out.println();
		String str1 = new String("abc");
		String str2 = new String("abc");
		HashSet<String> set = new HashSet<String>();
		set.add(str1);
		set.add(str2);
		System.out.println("Set for String or wrapper class");
		System.out.println(set);
		System.out.println(set.size());
		
		
		HashSet<Student> studentSet = new HashSet<Student>();
		studentSet.add(student1);
		studentSet.add(student2);
		System.out.println(studentSet);
		System.out.println(studentSet.size());
	}
}

class Student{
	private int rollNo;
	private String name;
	private float marks;
	
	public Student(int rollNo, String name, float marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
	
	
	
	public int getRollNo() {
		return rollNo;
	}



	public String getName() {
		return name;
	}



	public float getMarks() {
		return marks;
	}



	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Student) {
			if(((Student)obj).getRollNo() == getRollNo()) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public String toString() {
		return name + "," + rollNo + "," + marks;
	}
	
	
}
