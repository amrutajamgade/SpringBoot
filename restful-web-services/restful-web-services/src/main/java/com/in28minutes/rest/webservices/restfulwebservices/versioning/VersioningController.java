package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	// different URI
		//http://localhost:8095/v1/person
		@GetMapping("v1/person")
		public PersonV1 personV1() {
			return new PersonV1("Anupam");
		}
		
		
		@GetMapping("v2/person")
		public PersonV2 personV2() {
			return new PersonV2("Anupam","Bajpai");
		}
	
	// Versioning via request parameter start  Param version
		//http://localhost:8095/person/param?Version=1
		@GetMapping(value="/person/param",params="Version=1")
		public PersonV1 paramV1() {
			return new PersonV1("Anupam");
		}
		
		
		@GetMapping(value="/person/param",params="Version=2")
		public PersonV2 paramV2() {
			return new PersonV2("Anupam","Bajpai");
		}
	// Versioning via request parameter End 
		

	// Versioning via request header start - Header version
		//
		@GetMapping(value="/person/param",headers="X-API-VERSION=1")
		//http://localhost:8095/person/param and headeer as X-API-VERSION=1
		public PersonV1 headerV1() {
			return new PersonV1("Anupam");
		}
		
		
		@GetMapping(value="/person/param",headers="X-API-VERSION=2")
		public PersonV2 headerV2() {
			return new PersonV2("Anupam","Bajpai");
		}
	// Versioning via request header End 
		
	// Versioning via producer start - Accept Header version - MIME type / Content negotiation 
	
		@GetMapping(value="/person/producer",produces="application/abc.pqr.app-v1+json")
		// Header - accept - application/abc.pqr.app-v1+json
		public PersonV1 producerV1() {
			return new PersonV1("Anupam");
		}
		
		
		@GetMapping(value="/person/producer",produces="application/abc.pqr.app-v2+json")
		public PersonV2 producerV2() {
			return new PersonV2("Anupam","Bajpai");
		}
	// Versioning via producer  End 
}
