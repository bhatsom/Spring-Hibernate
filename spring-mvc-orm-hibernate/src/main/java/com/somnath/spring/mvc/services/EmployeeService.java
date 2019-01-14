package com.somnath.spring.mvc.services;

import com.somnath.spring.model.entity.Employee;
import com.somnath.spring.model.entity.Name;
import com.somnath.spring.model.ui.EmployeeUI;
import com.somnath.spring.orm.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public boolean addNewEmployee(EmployeeUI employeeUi) {
		Employee emp = new Employee();

		Name empName = new Name();
		empName.setFirstName(employeeUi.getFirstName());
		empName.setMiddleName(employeeUi.getMiddleName());
		empName.setLastName(employeeUi.getLastName());
		emp.setName(empName);

		emp.setJoiningDate(new org.joda.time.LocalDate());
		//emp.setSalary(new BigDecimal(employeeUi.getSalary()));
		emp.setSalary(employeeUi.getSalary());
		emp.setSsn(employeeUi.getSsn());

		System.out.println("Saving new employeeStoring " + emp);

		employeeDao.saveEmployee(emp);
		return true;
	}

	public List<EmployeeUI> getAllmployees() {
		List<Employee> empListFromDb = employeeDao.findAllEmployees();
		List<EmployeeUI> empList = new ArrayList<>();
		for(Employee emp : empListFromDb) {
			EmployeeUI empUi = new EmployeeUI(emp.getId(), emp.getName().firstName, emp.getName().middleName,
					emp.getName().lastName, emp.getJoiningDate().toString(), emp.getSalary(), emp.getSsn());
			empList.add(empUi);
		}
		return empList;
	}

}
