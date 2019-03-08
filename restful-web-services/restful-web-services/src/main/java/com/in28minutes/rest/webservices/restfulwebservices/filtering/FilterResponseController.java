package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterResponseController {

	public FilterResponseController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/filtering")
	public MappingJacksonValue retriveSomeBean() {
		SomeBean objSomeBean = new SomeBean("UserName","UserDetail","SSN");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider objFilterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter );
		
		MappingJacksonValue mapping = new MappingJacksonValue(objSomeBean);
		mapping.setFilters(objFilterProvider);
		
		return mapping;
	}
	
	
	
	/*@GetMapping("/filtering-list")
	public List<SomeBean> retriveSomeBeanList() {
		return Arrays.asList( 
				new SomeBean("UserName","UserDetail","SSN"),
				new SomeBean("UserName 2","UserDetail 2","SSN 2")
		);
	}*/

}
