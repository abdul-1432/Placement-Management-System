package com.tnsif.placement1;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PlacementService {
	
	@Autowired
	private PlacementRepository repo;
	
	//Retrieve all data
	public List<Placement> listAll() {
		
		return repo.findAll();
	}
	
	//Insert a data
	public void insert(Placement placement) {
		repo.save(placement);
	}
	
	//Retrieve specific data
	public Placement get(Long id) {
		return repo.findById(id).get();
	}
	
	//Delete
	public void delete(Long id) {
		repo.deleteById(id);
	}
}