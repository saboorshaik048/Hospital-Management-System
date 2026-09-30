package com.codegnan.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.entity.Visit;

@Repository
public interface VisitRepo extends JpaRepository<Visit, Integer> {
	public List<Visit> findAllByPatient(Patient patient);
	public List<Visit> findAllByDoctor(Doctor doctor);
	
//	@Query("SELECT v FROM Visit WHERE v.date >= fromDate and v.date <= toDate")
//	public List<Visit> findAllByPatientBetweenDates(Patient patient, Date fromDate, Date toDate);
}

/*

http://localhost:8080/doctors/2/visits
http://localhost:8080/patients/52/visits

*/