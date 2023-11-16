package com.example.usermodule;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	//RESTFUL API methods
	//1. for retrieval the data from the user
	@GetMapping("/user")
	public List<User> list(){
		
		return service.listall();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id){
		
		try {
			User user = service.get(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND); 
		}
		
	}
	
	//RESTFUL API methods for create operations
	@PostMapping("/user")
	public void add(@RequestBody User user) {
		service.save(user);
	}
	
	//update operation
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id){
		
		try {
			User user1 = service.get(id);
			service.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//delete operation
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
