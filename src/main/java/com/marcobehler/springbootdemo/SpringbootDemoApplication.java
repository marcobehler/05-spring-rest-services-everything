package com.marcobehler.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SpringbootDemoApplication {

	@Bean
	public Filter shallowEtagFilter() {
		return new ShallowEtagHeaderFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
