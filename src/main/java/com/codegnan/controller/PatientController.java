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

import com.codegnan.entity.Patient;
import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidPatientIdException;
import com.codegnan.service.PatientService;
import com.codegnan.service.VisitService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/patients")
public class PatientController {
	
	PatientService patientService;
	VisitService visitService;
	
	public PatientController(PatientService patientService, VisitService visitService) {
		this.patientService = patientService;
		this.visitService = visitService;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int id) throws InvalidPatientIdException{
		Patient patient = patientService.findPatientById(id); 
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/visits")
	public ResponseEntity<List<Visit>> getVisitsByPatient(@PathVariable int id) throws InvalidPatientIdException{
		Patient patient = patientService.findPatientById(id);
		List<Visit> visits = visitService.findVisitsByPatient(patient);
		return new ResponseEntity<List<Visit>>(visits, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Patient>> getAllPatients(){
		List<Patient> patients = patientService.findAllPatients();
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Patient> addNewPatient(@RequestBody Patient patient){
		Patient savedPatient = patientService.savePatient(patient);
		return new ResponseEntity<Patient>(savedPatient, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = {"application/json", "application/xml", "text/plain"})
	public ResponseEntity<Patient> editPatient(@PathVariable int id, @RequestBody Patient patient) throws InvalidPatientIdException {
	    if (id != patient.getId()) {
	        throw new InvalidPatientIdException("Patient id " + id + " is not matching with the patient " + patient.getId());
	    }
	    Patient updatedPatient = patientService.updatePatient(patient);
	    return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable int id) throws InvalidPatientIdException{
		Patient patient = patientService.deletePatient(id);
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}
	
}
