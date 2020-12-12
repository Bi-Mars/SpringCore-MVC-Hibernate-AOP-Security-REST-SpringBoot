package com.bimarsh.hibernate.employeeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	//fields resemble to database table
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String last_Name;
	
	@Column(name="company")
	private String company;
	
	//default constructor
	public Employee() {}

	//parameterized constructor
	public Employee(int employeeId, String firstName, String last_Name, String company) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.last_Name = last_Name;
		this.company = company;
	}

	//Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	//To String()
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", last_Name=" + last_Name
				+ ", company=" + company + "]";
	}
	
	
	
	
	
	
}
