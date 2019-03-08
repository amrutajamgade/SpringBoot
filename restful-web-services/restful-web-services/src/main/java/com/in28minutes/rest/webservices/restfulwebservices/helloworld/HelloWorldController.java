/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ANUPAMBA
 * 
 */

/**
 * ----------------------
 * Annotation used 
 * ----------------------
 * @RestController
 * @RequestMapping(method=RequestMethod.GET, path="/hello-world")
 * @GetMapping(path="/hello-world")	
 * @PathVariable
 * 
 * 
 * */


// controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * helloWorld()
	 * HTTP method 			==> GET
	 * URI - PATH- EndPoint ==> /hello-world
	 * Two ways to do it via @RequestMapping / @GetMapping
	 * return String 
	 * */
	// @RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")	
	public String helloWorld() {
		return "Hellow World....";
	}
	
	
	/**
	 * helloWorldwithBean ()
	 * HTTP method 			==> GET
	 * URI - PATH- EndPoint ==> /hello-world-bean
	 * return HelloWorldBean
	 * */
	@GetMapping(path="/hello-world-bean")	
	public HelloWorldBean helloWorldwithBean() {
		return new HelloWorldBean("Hellow World....");
	}

	
	/**
	 * helloWorldPathVariable(@PathVariable)
	 * HTTP method 			==> GET
	 * URI - PATH- EndPoint ==> /hello-world-bean/path-variable/{}
	 * {} ==> @PathVariable
	 * return helloWorldPathVariable
	 * */
	@GetMapping(path="/hello-world-bean/path-variable/{name}")	
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hellow World to %s", name) );
	}

	
	/**
	 *  helloWorldInternationalizede(@RequestHeader(name="Accept-Language", required=false) Locale locale)
	 * HTTP method 			==> GET
	 * URI - PATH- EndPoint ==> /hello-world-internationalized
	 * return String
	 * */
	@GetMapping(path="/hello-world-internationalized")	
	public String helloWorldInternationalizede(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null ,locale);
	}
	
	
	/**
	 *  helloWorldInternationalizede(@RequestHeader(name="Accept-Language", required=false) Locale locale)
	 * HTTP method 			==> GET
	 * URI - PATH- EndPoint ==> /hello-world-internationalized
	 * return String
	 * */
	@GetMapping(path="/hello-world-internationalizedContext")	
	public String helloWorldInternationalizedeContext() {
		return messageSource.getMessage("good.morning.message", null ,LocaleContextHolder.getLocale());
	}
}
