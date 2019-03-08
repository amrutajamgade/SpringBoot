/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.user.exception.UserNotFoundExcepetion;

/**
 * @author ANUPAMBA
 *
 */
@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userService;

	/***
	 * retrieveAllUser() 
	 * @GetMapping(path="/user/{id}")
	 * */
	@GetMapping(path="/users")
	public List<User> retrieveAllUser() {
		return userService.findAll();
	}
	
	
	/***saveUser(User)
	 * @PostMapping(path="/create-user")
	 * 
	 * */
	@PostMapping(path="/users")
	private ResponseEntity saveUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		
		/** 
		 * 201 - Created response back to client --  ResponseEntity.created(location).build()
		 * Also sending URL / location for newly created user -- in Header 
		 * 
		 * Sending Response for API call appending User id to actual API call URI */
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	
	
	/***retrieveSpecificUser(int id)
	 * @GetMapping(path="/user/{id}")
	 * 
	 * */
	@GetMapping(path="/user/{id}")
	private Resource retrieveSpecificUser(@PathVariable int id){
		
		User user = userService.findById(id);
		
		if(user == null ) {
			throw new UserNotFoundExcepetion(String.format("User with id - %s do not exist's", id));
		}
		
		//HATEOAS
		Resource<User> resource = new Resource(user);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUser());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	
	/***retrieveSpecificUser(int id)
	 * @GetMapping(path="/user/{id}")
	 * 
	 * */
	@DeleteMapping(path="/user/{id}")
	private void deleteSpecificUser(@PathVariable int id){
		
		User user = userService.findById(id);
		
		if(user == null ) {
			throw new UserNotFoundExcepetion(String.format("User with id - %s do not exist's", id));
		}
		
		userService.deleteById(id);
	}
}
