package com.somnath.spring.orm;

import com.somnath.spring.mvc.rootconfig.MyRootConfig;
import com.somnath.spring.mvc.webconfig.MyWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
https://www.javacodegeeks.com/2018/04/spring-mvc-tutorial-2.html
http://websystique.com/spring/spring4-hibernate4-mysql-maven-integration-example-using-annotations/
*/

public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { MyRootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MyWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
