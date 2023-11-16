package com.sprint2.studentmodule;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService 
{
	@Autowired
	private StudentRepository repo;
	
	// Retrieve all data
	public List<Student> listAll(){
		return repo.findAll();
	}
	
	//Insert data
	public void save(Student student){
		repo.save(student);
	}
	
	//Retrieve specific data
	public Student get(Integer id) {
		return repo.findById(id).get();
	}
	
	//Delete data
	public void delete(Student id){
		repo.delete(id);
	}

}
