package com.alok.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TopperStudent {
	public static void main(String[] args) {
		Student s1 = new Student("s1", 1, 90, 78, 88, 61);
		Student s2 = new Student("s2", 2, 58, 93, 73, 89);
		Student s3 = new Student("s3", 3, 94, 71, 59, 81);
		Student s4 = new Student("s4", 4, 71, 55, 75, 86);
		Student s5 = new Student("s5", 5, 90, 70, 81, 73);
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		
		List<Integer> marks = students
								.stream()							
								.map(obj -> (obj.getMaths() + obj.getPhysics() 
										+ obj.getChemistry() + obj.getEnglish()))
								.collect(Collectors.toList());
		
		
		
		int topper = -1;
		int topperIdx = 0;
		for(int i=0; i<marks.size(); i++) {
			if(topper < marks.get(i)) {
				topper = marks.get(i);
				topperIdx = i;
			}
		}
		
		System.out.println(marks);
		System.out.println("Topper is : "  + students.get(topperIdx));
			
	}
	
	
}	

class Student{
	private String name;
	private Integer rollNo;
	private Integer maths;
	private Integer physics;
	private Integer chemistry;
	private Integer english;
	
	
	
	public Student(String name, Integer rollNo, Integer maths, Integer physics, Integer chemistry, Integer english) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.maths = maths;
		this.physics = physics;
		this.chemistry = chemistry;
		this.english = english;
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
	 * @return the rollNo
	 */
	public Integer getRollNo() {
		return rollNo;
	}
	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	/**
	 * @return the maths
	 */
	public Integer getMaths() {
		return maths;
	}
	/**
	 * @param maths the maths to set
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}
	/**
	 * @return the physics
	 */
	public Integer getPhysics() {
		return physics;
	}
	/**
	 * @param physics the physics to set
	 */
	public void setPhysics(Integer physics) {
		this.physics = physics;
	}
	/**
	 * @return the chemistry
	 */
	public Integer getChemistry() {
		return chemistry;
	}
	/**
	 * @param chemistry the chemistry to set
	 */
	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}
	/**
	 * @return the english
	 */
	public Integer getEnglish() {
		return english;
	}
	/**
	 * @param english the english to set
	 */
	public void setEnglish(Integer english) {
		this.english = english;
	}
	
	@Override
	public String toString() {
		return "Name =" + name + " Roll No =" + rollNo +  "]";
	}
}
