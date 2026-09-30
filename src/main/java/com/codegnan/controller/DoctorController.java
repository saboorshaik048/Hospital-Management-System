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

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Visit;
import com.codegnan.exception.InvalidDoctorIdException;
import com.codegnan.service.DoctorService;
import com.codegnan.service.VisitService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/doctors")
// Enable CORS for all origins and methods (GET, POST, PUT, DELETE)
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DoctorController {

    private final DoctorService doctorService;
    private final VisitService visitService;

    public DoctorController(DoctorService doctorService, VisitService visitService) {
        this.doctorService = doctorService;
        this.visitService = visitService;
    }

    // GET all doctors
    @GetMapping("")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAllDoctors());
    }

    // GET doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) throws InvalidDoctorIdException {
        return ResponseEntity.ok(doctorService.findDoctorById(id));
    }

    // GET visits by doctor
    @GetMapping("/{id}/visits")
    public ResponseEntity<List<Visit>> getVisitsByDoctor(@PathVariable int id) throws InvalidDoctorIdException {
        Doctor doctor = doctorService.findDoctorById(id);
        return ResponseEntity.ok(visitService.findVisitsByDoctor(doctor));
    }

    // POST to create a new doctor
    @PostMapping("")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.hireDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }

    // PUT to update a doctor's information by ID
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) throws InvalidDoctorIdException {
        if (id != doctor.getId()) {
            throw new InvalidDoctorIdException("Doctor ID " + doctor.getId() + " does not match provided ID " + id);
        }
        Doctor updatedDoctor = doctorService.updateDoctor(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    // DELETE a doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable int id) throws InvalidDoctorIdException {
        Doctor deletedDoctor = doctorService.deleteDoctor(id);
        return ResponseEntity.ok(deletedDoctor);
    }
}
