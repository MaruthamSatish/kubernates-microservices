/**
 * 
 */
package com.easytobuy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 *
 */
@RestController
public class CategoryRestAPI {
	@GetMapping("/hello")
	public String helloDisplay() {
		return "Hey Sathi Ur In K8";
	}

}
