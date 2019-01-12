package com.somnath.spring.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

	@Column(name = "FIRST_NAME", nullable = false)
	public String firstName;

	public String middleName;

	@Column(name = "LAST_NAME", nullable = false)
	public String lastName;

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

	@Override
	public String toString() {
		return "Name{" +
				"firstName='" + firstName + '\'' +
				", middleName='" + middleName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}

}
