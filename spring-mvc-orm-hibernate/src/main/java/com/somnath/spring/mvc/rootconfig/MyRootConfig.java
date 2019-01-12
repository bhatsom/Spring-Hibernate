package com.somnath.spring.mvc.rootconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.somnath.spring.mvc.controllers"},
		excludeFilters = {
				@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
		})
public class MyRootConfig {
}
