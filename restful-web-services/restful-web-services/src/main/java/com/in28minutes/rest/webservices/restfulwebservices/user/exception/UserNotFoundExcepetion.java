/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author ANUPAMBA
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExcepetion extends RuntimeException {

	/**
	 * 
	 */
	public UserNotFoundExcepetion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */

	public UserNotFoundExcepetion(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public UserNotFoundExcepetion(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public UserNotFoundExcepetion(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public UserNotFoundExcepetion(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
