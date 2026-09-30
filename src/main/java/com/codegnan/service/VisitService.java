package com.codegnan.service;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidVisitIdException;
import com.codegnan.repo.VisitRepo;

@Service
public class VisitService {

	private VisitRepo visitRepo;

	public VisitService(VisitRepo visitRepo) {
		super();
		this.visitRepo = visitRepo;
	}
	
	public Visit saveVisit(Visit visit) {
		Visit savedVisit = visitRepo.save(visit);
		System.out.println("Saved visit (Service) : " + savedVisit);
		return savedVisit;
	}
	
	public List<Visit> findVisitsByPatient(Patient patient){
		return visitRepo.findAllByPatient(patient);
	}
	
	public List<Visit> findVisitsByDoctor(Doctor doctor){
		return visitRepo.findAllByDoctor(doctor);
	}
	
	public List<Visit> findVisits(){
		return visitRepo.findAll();
	}
	
	public Visit findVisitById(int id) throws InvalidVisitIdException {
		Optional<Visit> optVisit = visitRepo.findById(id);
		if( optVisit.isEmpty() ) {
			throw new InvalidVisitIdException("Visit ID "+id+" is not valid");
		}
		return optVisit.get();
	}
	
	public Visit editVisit(Visit visit) throws InvalidVisitIdException {
		findVisitById(visit.getId());
		return visitRepo.save(visit);
	}
	
	public Visit deleteVisit(int id) throws InvalidVisitIdException {
		Visit visit = findVisitById(id);
		visitRepo.deleteById(id);
		return visit;
	}

}
