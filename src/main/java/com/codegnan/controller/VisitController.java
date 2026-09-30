package com.codegnan.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidVisitIdException;
import com.codegnan.service.VisitService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/visits")
public class VisitController {
	
	VisitService visitService;
	
	public VisitController(VisitService visitService) {
		this.visitService = visitService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Visit>> getAllVisits(){
		List<Visit> visits = visitService.findVisits();
		return new ResponseEntity<List<Visit>>(visits, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Visit> getVisitById(@PathVariable int id) throws InvalidVisitIdException{
		Visit visit = visitService.findVisitById(id);
		return new ResponseEntity<Visit>(visit, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Visit> saveVisit(@RequestBody Visit visit){
		Visit savedVisit = visitService.saveVisit(visit);
		System.out.println("Saved Visit (Controller) : "+savedVisit);
		return new ResponseEntity<Visit>(savedVisit, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Visit> editVisit(@PathVariable int id, @RequestBody Visit visit) throws InvalidVisitIdException{
		if ( id != visit.getId() ) {
			throw new InvalidVisitIdException("Visit ID "+id+" is not matching with editing visit "+visit.getId());
		}
		Visit savedVisit = visitService.editVisit(visit);
		return new ResponseEntity<Visit>(savedVisit, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Visit> deleteVisit(@PathVariable int id) throws InvalidVisitIdException{
		Visit visit = visitService.deleteVisit(id);
		return new ResponseEntity<Visit>(visit, HttpStatus.OK);
	}
}
