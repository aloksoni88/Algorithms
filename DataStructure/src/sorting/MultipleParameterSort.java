package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MultipleParameterSort {
	public static void main(String[] args) {
		MultipleParameterTest obj1 = new MultipleParameterTest(1, "Atul", 10000f);
		MultipleParameterTest obj2 = new MultipleParameterTest(1, "Alok", 20000f);
		MultipleParameterTest obj3 = new MultipleParameterTest(1, "Atul", 15000f);
		MultipleParameterTest obj4 = new MultipleParameterTest(2, "Anshul", 15000f);
		MultipleParameterTest obj5 = new MultipleParameterTest(3, "Anu", 15000f);
		MultipleParameterTest obj6 = new MultipleParameterTest(3, "Amay", 10000f);
		
		ArrayList<MultipleParameterTest> list = new ArrayList<MultipleParameterTest>();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.add(obj4);
		list.add(obj5);
		list.add(obj6);
		
		
		Collections.sort(list, new Comparator<MultipleParameterTest>() {

			public int compare(MultipleParameterTest test1, MultipleParameterTest test2) {
				int c;
				c = test1.getId().compareTo(test2.getId());
				if(c == 0) {
					c = test1.getName().compareTo(test2.getName());
				}
				if(c == 0) {
					c = test1.getSalary().compareTo(test2.getSalary());
				}			
				return c;
			}
		});
		
		System.out.println(list);
		
	}
}

class MultipleParameterTest{	
	private Integer id;
	private String name;
	private Float salary;
	
	
	public MultipleParameterTest(Integer id, String name, Float salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the salary
	 */
	public Float getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", salary=" + salary + "]" + "\n";
	}
	
	
	
	
}
