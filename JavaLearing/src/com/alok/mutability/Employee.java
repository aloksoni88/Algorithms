package com.alok.mutability;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class Employee {
	private long id;   
    private String name;   
    private Date dateOfBirth;    
    private BigDecimal salary;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	} 
	
	@Override
	public String toString() {
		return id+", " + name + ", " + dateOfBirth + ", " + salary ;
	}
    
	
	public static void main(String[] args) {    
	    HashMap<Employee,String> employeeMap = new HashMap<Employee,String>();  
	    Employee employee1 = new Employee();    
	    employee1.setId(1);    
	    employee1.setName("Sachin");    
	    employee1.setDateOfBirth(new Date(1987,2,1));    
	    employee1.setSalary(new BigDecimal(100000));    
	    employeeMap.put(employee1,"India");    
	    // Some Business logic    
	    // In the second Operation I am updating the same employee with the newly initailized Employee Object
	    Employee employee2 = new Employee();    
	    employee2.setId(1);    
	    employee2.setName("Sachin");    
	    employee2.setDateOfBirth(new Date(1987,2,1));    
	    employee2.setSalary(new BigDecimal(100000));  
	    // Here we wanted to update the same Employee to Japan
	    employeeMap.put(employee2,"Japan");
	    System.out.println(employeeMap.size());
	    System.out.println(employeeMap); 
	    // Output of this will be 2 as below
	    /* 
	        {Employee{id=1, name='Sachin', dateOfBirth=Tue Mar 01 00:00:00 IST 3887, salary=100000}=Japan, 
	        Employee{id=1, name='Sachin', dateOfBirth=Tue Mar 01 00:00:00 IST 3887, salary=100000}=India}
	    */
	}
	
	@Override    
    public boolean equals(Object o) {        
        if (this == o) return true;        
        if (o == null || getClass() != o.getClass()) return false;        
        Employee employee = (Employee) o;        
        if (id != employee.id) return false;        
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;        
        if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null) return false;        
        return salary != null ? salary.equals(employee.salary) : employee.salary == null;    
    }    
    @Override    
    public int hashCode() {        
        int result = (int) (id ^ (id >>> 32));        
        result = 31 * result + (name != null ? name.hashCode() : 0);        
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;    
    } 
    
}
