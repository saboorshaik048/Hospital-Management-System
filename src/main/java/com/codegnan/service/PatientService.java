package com.codegnan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codegnan.entity.Patient;
import com.codegnan.exception.InvalidPatientIdException;
import com.codegnan.repo.PatientRepo;

@Service
public class PatientService {
	
	private PatientRepo patientRepo;

	public PatientService(PatientRepo patientRepo) {
		this.patientRepo = patientRepo;
	}
	
	public Patient findPatientById(int id) throws InvalidPatientIdException {
		Optional<Patient> optPatient = patientRepo.findById(id);
		if ( optPatient.isEmpty() ) {
			throw new InvalidPatientIdException("Paitnet ID "+id+" is not valid");
		}
		return optPatient.get();
	}
	
	public List<Patient> findAllPatients(){
		return patientRepo.findAll();
	}
	
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	public Patient updatePatient(Patient patient) throws InvalidPatientIdException {
		findPatientById(patient.getId());
		return patientRepo.save(patient);
	}
	
	public Patient deletePatient(int id) throws InvalidPatientIdException {
		Patient patient = findPatientById(id); 
		patientRepo.deleteById(id);
		return patient;
	}

}
