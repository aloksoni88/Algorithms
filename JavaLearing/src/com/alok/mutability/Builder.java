package com.alok.mutability;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Builder {

	public static void main(String[] args) {
		
		HashMap<ImmutableEmp, String> employeeMap = new HashMap<ImmutableEmp, String>();

		ImmutableEmp employee1 = ImmutableEmp.EmpBuilder.anEmployee().withId(1).withName("Sachin")
				.withDateOfBirth(new Date(1987, 2, 1)).withSalary(new BigDecimal(100000)).build();
		employeeMap.put(employee1, "India");
		
		
		for (Map.Entry<ImmutableEmp, String> employeeStringEntry : employeeMap.entrySet()) {
			System.out.println(employeeStringEntry.getKey().hashCode());
		}
		ImmutableEmp immutableUpdatedEmployee1 = ImmutableEmp.EmpBuilder.anEmployee(employee1).withName("Rahul")
				.build();
		for (Map.Entry<ImmutableEmp, String> employeeStringEntry : employeeMap.entrySet()) {
			System.out.println(employeeStringEntry.getKey().hashCode());
		}
		System.out.println(employeeMap.get(immutableUpdatedEmployee1));
		// Returns null
		ImmutableEmp employee2 = ImmutableEmp.EmpBuilder.anEmployee().withId(1).withName("Sachin")
				.withDateOfBirth(new Date(1987, 2, 1)).withSalary(new BigDecimal(100000)).build();
		System.out.println(employee2.hashCode());
		System.out.println(employeeMap.get(employee2));
		// Now this works fine and it shall return the correct object from the HashMap

	}
}
