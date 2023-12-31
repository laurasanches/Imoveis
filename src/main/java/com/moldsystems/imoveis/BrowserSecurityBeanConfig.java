package com.moldsystems.imoveis;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class BrowserSecurityBeanConfig {
	@Bean
	public FilterRegistrationBean<Filter> hiddenHttpMethodFilter(){
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>(new HiddenHttpMethodFilter());
		return filterRegistrationBean;
	}
}
