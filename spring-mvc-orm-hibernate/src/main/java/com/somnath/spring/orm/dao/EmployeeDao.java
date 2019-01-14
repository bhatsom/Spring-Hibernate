package com.somnath.spring.orm.dao;

import com.somnath.spring.model.entity.Employee;

import java.util.List;
 
public interface EmployeeDao {
 
    void saveEmployee(Employee employee);
     
    List<Employee> findAllEmployees();
     
    void deleteEmployeeBySsn(String ssn);
     
    Employee findBySsn(String ssn);
     
    void updateEmployee(Employee employee);
}