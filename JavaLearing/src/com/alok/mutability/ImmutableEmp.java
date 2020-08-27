package com.alok.mutability;

import java.math.BigDecimal;
import java.util.Date;

public final class ImmutableEmp {
	private final long id;
	private final String name;
	private final Date dateOfBirth;
	private final BigDecimal salary;

	public ImmutableEmp(EmpBuilder employeeBuilder) {
		this.id = employeeBuilder.id;
		this.name = employeeBuilder.name;
		this.dateOfBirth = employeeBuilder.dateOfBirth;
		this.salary = employeeBuilder.salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ImmutableEmp employee = (ImmutableEmp) o;
		if (id != employee.id)
			return false;
		if (name != null ? !name.equals(employee.name) : employee.name != null)
			return false;
		if (dateOfBirth != null ? !dateOfBirth.equals(employee.dateOfBirth) : employee.dateOfBirth != null)
			return false;
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

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", dateOfBirth=" + dateOfBirth + ", salary="
				+ salary + '}';
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		return (Date) dateOfBirth.clone();
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public static final class EmpBuilder {
		private long id;
		private String name;
		private Date dateOfBirth;
		private BigDecimal salary;

		private EmpBuilder() {
		}

		public static EmpBuilder anEmployee() {
			return new EmpBuilder();
		}

		public static EmpBuilder anEmployee(ImmutableEmp employee) {
			return anEmployee().withId(employee.getId()).withName(employee.getName())
					.withDateOfBirth(employee.getDateOfBirth()).withSalary(employee.getSalary());
		}

		public EmpBuilder withId(long id) {
			this.id = id;
			return this;
		}

		public EmpBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public EmpBuilder withDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}

		public EmpBuilder withSalary(BigDecimal salary) {
			this.salary = salary;
			return this;
		}

		public ImmutableEmp build() {
			return new ImmutableEmp(this);
		}
	}

}
