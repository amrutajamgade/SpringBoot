package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	public SwaggerConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(new HashSet<String>(Arrays.asList( "appication/jason","application/xml")))
				.consumes(new HashSet<String>(Arrays.asList( "appication/jason","application/xml")));
	} 
	
	
	public static final Contact DEFAULT_CONTACT = new Contact("Anupa Bajpai","https://TestTP.com", "anupambajpaice@gmail.com");
	 
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Anupam's API Title ", "Anupam's TEST API DOCS","1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());

}
