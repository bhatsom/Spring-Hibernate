package com.somnath.spring.model.ui;

import com.somnath.spring.model.entity.Employee;

import java.math.BigDecimal;

public class EmployeeUI {

	public EmployeeUI(){}

	public EmployeeUI(int id, String firstName, String middleName, String lastName,
	                  String joiningDate, BigDecimal salary, String ssn) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.ssn = ssn;
	}

	private int id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String joiningDate;
 
    private BigDecimal salary;
     
    private String ssn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String  getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String  joiningDate) {
		this.joiningDate = joiningDate;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
