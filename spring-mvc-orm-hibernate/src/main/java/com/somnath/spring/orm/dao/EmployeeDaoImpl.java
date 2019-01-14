package com.somnath.spring.orm.dao;

import java.util.List;

import com.somnath.spring.model.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao{
 
    public void saveEmployee(Employee employee) {
        persist(employee);
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }
 
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }
 
     
    public Employee findBySsn(String ssn){
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Employee) criteria.uniqueResult();
    }
     
    public void updateEmployee(Employee employee){
        getSession().update(employee);
    }
     
}