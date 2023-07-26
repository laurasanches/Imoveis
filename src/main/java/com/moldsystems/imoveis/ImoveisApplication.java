package com.moldsystems.imoveis;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class ImoveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImoveisApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
	/*
	@SuppressWarnings("deprecation")
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter {
		
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/imoveis");
		}
	}
	*/
}
