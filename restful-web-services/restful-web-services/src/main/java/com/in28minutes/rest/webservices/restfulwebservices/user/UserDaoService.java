package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>() ;
	private static int userCount = 3;
	
	static {
		users.add(new User(1 , "Anupam", new Date()));
		users.add(new User(2 , "Anurag", new Date()));
		users.add(new User(3 , "Amruta", new Date()));
		
		
	}
	
	
	// Fetch all users
	public List<User> findAll () {
		return users;
	}

	
	// Save user in static list
	public User save (User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		 users.add(user);
		 return user;
	}
	
	


	// Fetch Specific user based on id
	public User findById ( int id) {
		 return users.stream().filter( user -> user.getId().equals(id)).findAny().orElse(null);
	}


	public void deleteById(int id) {
		 users.removeIf( user -> user.getId().equals(id));
	}
}
