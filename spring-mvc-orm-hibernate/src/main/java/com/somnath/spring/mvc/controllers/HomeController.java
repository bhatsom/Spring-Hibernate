package com.somnath.spring.mvc.controllers;

import com.somnath.spring.dao.EmployeeDao;
import com.somnath.spring.model.Employee;
import com.somnath.spring.model.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
@RequestMapping("/test")
public class HomeController {

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model homePageModel) {

		// Java 8 local date
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		homePageModel.addAttribute("localDate", localDate.format(formatter));

		homePageModel.addAttribute("message", "Welcome To: Spring MVC");

		return "homePage";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("caption", "Add New Employee..");
		return "addEmployee";
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(HttpServletRequest request,
	                           HttpServletResponse response,
	                           Model model) {
		//TODO - add persistence logic
		Employee emp = new Employee();

		Name empName = new Name();
		empName.setFirstName(request.getParameter("firstName"));
		empName.setMiddleName(request.getParameter("middleName"));
		empName.setLastName(request.getParameter("lastName"));
		emp.setName(empName);

		emp.setJoiningDate(new org.joda.time.LocalDate());
		emp.setSalary(new BigDecimal(request.getParameter("salary")));
		emp.setSsn(request.getParameter("ssn"));

		System.out.println("Storing " + emp);

		employeeDao.saveEmployee(emp);

		model.addAttribute("message", "Add New Employee..");
		return "savedEmployee";
	}

}
