package com.example.usermodule;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	//object or repository
	@Autowired
	private UserRepository repo;
	
	//retrieve all the data
	public List<User> listall(){
		return repo.findAll();
		
	}
	
	//insert the data
	public void save(User user) {
		repo.save(user);	
	}
	
	//retreive specific data
	public User get(Integer id) {
		return repo.findById(id).get();
	}
	
	//delete
	public void delete(Integer id) {
		repo.deleteById(id);
	}	
	
	
}
