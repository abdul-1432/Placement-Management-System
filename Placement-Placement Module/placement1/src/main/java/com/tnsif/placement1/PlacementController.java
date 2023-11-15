package com.tnsif.placement1;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacementController {
	
	@Autowired
	private PlacementService service;
	
	// RESTful API methods for Retrieval operations
	@CrossOrigin("http://localhost:4200")

	@GetMapping("/placement")
	public List<Placement> list()
	{
		return service.listAll();
	}
	
	@GetMapping("/placement/{id}")
	public ResponseEntity<Placement> get(@PathVariable Long id) {
		try
		{
		Placement placement = service.get(id);
		return new ResponseEntity<Placement>(placement, HttpStatus.OK);
		}
		catch (NoSuchElementException e)
		{
		return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
		}
	}
	
	// RESTful API method for Create operation
	@PostMapping("/placement")
	public void add(@RequestBody Placement placement)
	{
		service.insert(placement);
	}
	
	// RESTful API method for Update operation
	@PutMapping("/placement/{id}")
	public ResponseEntity<?> update(@RequestBody Placement placement, @PathVariable Long id)
	{
	try
	{
	Placement objPlacement = service.get(id);
	service.insert(placement);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	// RESTful API method for Delete operation
	@DeleteMapping("/placement/{id}")
	public void delete(@PathVariable Long id)
	{
	service.delete(id);
	}

}