/**
 * 
 */
package com.anupam.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anupam.microservices.limitsservice.bean.LimitConfiguration;

/**
 * @author ANUPAMBA
 *
 */

@RestController
public class LimitsConfiguratonController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitFromConfigurations() {
		return new LimitConfiguration(config.getMaximum(),config.getMinimum());
		
	}
}
