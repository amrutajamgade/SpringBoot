package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.in28minutes.rest.webservices.restfulwebservices.user.User;

import io.swagger.annotations.ApiModel;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author ANUPAMBA
 * 
 */

/**
 * ----------------------
 * Annotation used 
 * ----------------------
 * Below first set of annotation add these classes in the Application context so they get applied at application startup
 * @SpringBootApplication (scanBasePAckageClasses={}) == Component annotation == main package for scanning for all component and its subpackage
 * @RestController  == Component annotation ==
 * @Autowired -- also @Resource @Inject -- AutoWire is more powerful 
 * @Component  == Component annotation ==
 * @ControllerAdvice
 * @ExceptionHandler(UserNotFoundExcepetion.class)
 * @Bean  == Component annotation ==
 * @Configuration  == Component annotation == has caching of class object while component dont have the same
 * @Repository  == Component annotation ==
 * @Service  == Component annotation ==
 * 
 * 
 * 
 * @RequestMapping(method=RequestMethod.GET, path="/hello-world")
 * @GetMapping(path="/hello-world")	
 * @GetMapping(value="/person/param",params="Version=1")
 * @PostMapping(path="/save/")
 * @DeleteMapping(path="/user/{id}")
 * @PathVariable User user
 * @RequestBody User user
 * @ResponseStatus(HttpStatus.NOT_FOUND)
 * @RequestHeader(name="Accept-Language", required=false) Locale locale
 * @JsonIgnore
 * @JsonIgnoreProperties(value={"field2"})
 * @JsonFilter("SomeBeanFilter")
 * 
 * 
 * @Entity
 * @Id
 * @GeneratedValue
 * @ManyToOne(fetch=FetchType.LAZY)
 * 
 * @EnableSwagger2
 * @ApiModel
 * 
 * @Value("${Application.properties variable }")
 * @ConditionalOnProperty("") / @ConditionalOnProperty("name of property", havingValue="value",matchIfMissing=true) // if value match or missing
 * 
 * */

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver sessionLocaleResolver = new AcceptHeaderLocaleResolver();
		
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	/*@Bean
	// THIS Method NAME HAS TO BE messageSource
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	Alternative to this method is to put in the application.properties
	*/
}

