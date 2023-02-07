package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@SpringBootApplication
public class BlogApplicationUsingSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplicationUsingSpringSecurityApplication.class, args);
	}

	@Bean
	LocalValidatorFactoryBean validate(MessageSource source) {
		
		LocalValidatorFactoryBean lvfb  = new LocalValidatorFactoryBean();
		lvfb.setValidationMessageSource(source);
	
		return lvfb;
	}
	
}
