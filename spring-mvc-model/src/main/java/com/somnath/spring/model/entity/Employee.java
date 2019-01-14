package com.somnath.spring.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.*;

import org.joda.time.LocalDate;
 
@Entity
@Table(name="EMPLOYEE")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Name name;
 
    @Column(name = "JOINING_DATE", nullable = false)
    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate joiningDate;
 
    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;
     
    @Column(name = "SSN", unique=true, nullable = false)
    private String ssn;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public Name getName() {
        return name;
    }
 
    public void setName(Name name) {
        this.name = name;
    }
 
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
 
    public void setJoiningDate(LocalDate joiningDate) {
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
 
    /*@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        return true;
    }*/

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return id == employee.id &&
				Objects.equals(name, employee.name) &&
				Objects.equals(joiningDate, employee.joiningDate) &&
				Objects.equals(salary, employee.salary) &&
				Objects.equals(ssn, employee.ssn);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, joiningDate, salary, ssn);
	}

	@Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", joiningDate="
                + joiningDate + ", salary=" + salary + ", ssn=" + ssn + "]";
    }

}
