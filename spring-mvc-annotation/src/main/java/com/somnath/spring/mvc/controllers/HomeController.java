package com.somnath.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage(Model homePageModel) {

		// Java 8 local date
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		homePageModel.addAttribute("localDate", localDate.format(formatter));

		homePageModel.addAttribute("message", "Welcome To: Spring MVC");

		return "homePage";
	}

}
