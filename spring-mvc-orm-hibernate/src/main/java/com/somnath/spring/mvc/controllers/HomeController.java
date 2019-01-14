package com.somnath.spring.mvc.controllers;

import com.somnath.spring.model.ui.EmployeeUI;
import com.somnath.spring.mvc.services.EmployeeService;
import com.somnath.spring.orm.dao.EmployeeDao;
import com.somnath.spring.model.entity.Employee;
import com.somnath.spring.model.entity.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Controller
@RequestMapping("/test")
public class HomeController {

	@Autowired(required = true)
	private EmployeeService employeeService;

	private static final String STATUS_SUCCESS = "success";
	private static final String STATUS_FAILURE = "fail";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model homePageModel) {
		LocalDate localDate = LocalDate.now(); // Java 8 local date
		DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		homePageModel.addAttribute("localDate", localDate.format(formatter));
		homePageModel.addAttribute("message", "Welcome To: Spring MVC");
		return "homePage";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(Model model) {
		ModelAndView mav = new ModelAndView("addEmployee");
		mav.addObject("caption", "Add New Employee");
		mav.addObject("employee", new EmployeeUI());
		return mav;
	}

	@RequestMapping(value = "/listAllEmployees", method = RequestMethod.POST)
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("addEmployee");
		mav.addObject("caption", "All employees listed below:");
		try {
			List<EmployeeUI> employeeUIList = employeeService.getAllmployees();
			mav.addObject("allEmployees", employeeUIList);
			mav.addObject("status", STATUS_SUCCESS);
		} catch (Exception ex) {
			ex.printStackTrace();
			mav.addObject("status", STATUS_FAILURE);
			mav.addObject("message", "Error listing employees. See reason below.");
			mav.addObject("failureReason", ex.getMessage());
		}
		return mav;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(HttpServletRequest request,
	                           HttpServletResponse response,
	                           Model model,
	                           @ModelAttribute("employee") EmployeeUI employeeUi) {
		try {
			employeeService.addNewEmployee(employeeUi);
			model.addAttribute("message", "New employee added successfully.");
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("message", "Add new employee failed. See reason below.");
			model.addAttribute("failureReason", ex.getMessage());
		}
		model.addAttribute("caption", "New Employee Addition");
		return "saveEmployee";
	}

}
