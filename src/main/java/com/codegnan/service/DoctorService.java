package com.codegnan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.entity.Doctor;
import com.codegnan.exception.InvalidDoctorIdException;
import com.codegnan.repo.DoctorRepo;

@Service
public class DoctorService {
	
	private DoctorRepo doctorRepo;
	
	public DoctorService(DoctorRepo doctorRepo) {
		super();
		this.doctorRepo = doctorRepo;
	}
	
	public Doctor hireDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	public Doctor findDoctorById(int id) throws InvalidDoctorIdException {
		Optional<Doctor> optDoctor = doctorRepo.findById(id);
		if( optDoctor.isEmpty() ) {
			throw new InvalidDoctorIdException("Doctor ID "+id+" is not valid.");
		}
		return optDoctor.get();
	}
	
	public List<Doctor> findAllDoctors(){
		return doctorRepo.findAll();
	}
	
	
	public Doctor updateDoctor(Doctor doctor) throws InvalidDoctorIdException {
		findDoctorById(doctor.getId());
		return doctorRepo.save(doctor);
	}
	
	public Doctor deleteDoctor(int id) throws InvalidDoctorIdException {
		Doctor doctor = findDoctorById(id);
		doctorRepo.deleteById(id);
		return doctor;
	}

}
