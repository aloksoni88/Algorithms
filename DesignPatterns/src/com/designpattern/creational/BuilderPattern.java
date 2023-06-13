package com.designpattern.creational;

public class BuilderPattern {
	public static void main(String[] args) {
		Employee emp = new Employee.EmployeeBuilder("Alok", "Bangalore", 1988)
				.setProfession("Software Engineer")
				.setSalary(8000000)
				.build();
		
		System.out.println(emp);
	}
}

class Employee {
	private String name;
	private String address;
	private long dob;
	private String profession;
	private float salary;
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the dob
	 */
	public long getDob() {
		return dob;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", dob=" + dob + ", profession=" + profession
				+ ", salary=" + salary + "]";
	}

	private Employee(EmployeeBuilder builder) {
		this.name = builder.name;
		this.address = builder.address;
		this.dob = builder.dob;
		this.profession = builder.profession;
		this.salary = builder.salary;
	}
	

	
	public static class EmployeeBuilder{
		//mandatory parameters
		private String name;
		private String address;
		private long dob;
		
		//optional parameters
		private String profession;
		private float salary;
		
		public EmployeeBuilder(String name, String address, long dob) {
			this.name = name;
			this.address = address;
			this.dob = dob;
		}

		/**
		 * @param profession the profession to set
		 */
		public EmployeeBuilder setProfession(String profession) {
			this.profession = profession;
			return this;
		}

		/**
		 * @param salary the salary to set
		 */
		public EmployeeBuilder setSalary(float salary) {
			this.salary = salary;
			return this;
		}
		
		//build method which will build employee object
		public Employee build() {
			return new Employee(this);
		}
	}
	
}
