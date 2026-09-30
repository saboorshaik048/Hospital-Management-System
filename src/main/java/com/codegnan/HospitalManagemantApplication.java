package com.codegnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HospitalManagemantApplication {

	public static void main(String[] args) {
		
		
		ApplicationContext ctxt = SpringApplication.run(HospitalManagemantApplication.class, args);
		
		
		/*PatientService patientService = ctxt.getBean(PatientService.class);
		DoctorService doctorService = ctxt.getBean(DoctorService.class);
		VisitService visitService = ctxt.getBean(VisitService.class);
		*/
		
		/*
		try {
			Patient p1 = patientService.findPatientById(2);
			Doctor d1 = doctorService.findDoctorById(1);
			
			List<Visit> visits1 = visitService.findVisitsByDoctor(d1);
			List<Visit> visits2 = visitService.findVisitsByPatient(p1);
			
			
			System.out.println("Visits of Doctor "+d1+" : ");
			System.out.println("Visits : ");
			for( Visit visit : visits1) {
				System.out.println(visit);
			}
			System.out.println("Visits of Patient "+p1+" : "+visits2);
		}
		catch(InvalidPatientIdException e) {
			e.printStackTrace();
		}
		catch(InvalidDoctorIdException e) {
			e.printStackTrace();
		}
		
		*/
		
		
		/*
		Doctor doctor = new Doctor("Doc_01", "doc1@gmail.com", "9999999999", "M", "Dermitology", 25, "MS", 450000);
		
		Doctor hiredDoctor = doctorService.hireDoctor(doctor);
		try {
			Patient patient1 = new Patient("Pat_01", "pat1@gmail.com", "1111111111", "M", "01-03-2020", 41);
			Patient patient2 = new Patient("Pat_02", "pat2@gmail.com", "2222222222", "M", "01-03-2020", 31);
			
			Visit visit1 = new Visit("01-03-2020", "Skin Alergy", 79.5, 98.6, 123.5, "Cash");
			Visit visit2 = new Visit("01-03-2020", "Skin Rashes", 77.0, 98.6, 120.5, "UPI");
			
			visit1.setPatient(patient1);
			visit1.setDoctor(doctor);
			
			visit2.setPatient(patient2);
			visit2.setDoctor(doctor);
			
			patient1.setVisits(Arrays.asList(visit1));
			patient2.setVisits(Arrays.asList(visit2));
			doctor.setVisits(Arrays.asList(visit1, visit2));

			Patient savedPatient1 = patientService.savePatient(patient1);
			Patient savedPatient2 = patientService.savePatient(patient2);
			
			Visit savedVisit1 = visitService.saveVisit(visit1);
			Visit savedVisit2 = visitService.saveVisit(visit2);
		}
		catch(InvalidDateFormatException e) {
			e.printStackTrace();
		}
		*/
		
		
		// Editing a Patient
//		Patient patient = new Patient(2, "Pat_01", "pat1@gmail.com", "2222222222", "M", new Date(new GregorianCalendar(2020, 03, 01).getTimeInMillis()	), 41);
//		
//		PatientService patientService = ctxt.getBean(PatientService.class);
//		
//		System.out.println("Before saving : "+patient);
//		Patient savedPatient;
//		try {
//			savedPatient = patientService.updatePatient(patient);
//			System.out.println("After updatinf : "+savedPatient);
//		} catch (InvalidPatientIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
