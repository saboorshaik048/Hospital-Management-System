package com.codegnan.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor extends Person {
	String specialization;
	int experience;
	String degrees;
	double salary;

	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	@JsonIgnore
	List<Visit> visits;

	public Doctor() {
		super();
	}

	public Doctor(int id, String name, String email, String mobile, String gender, String specialization,
			int experience, String degrees, double salary) {
		super(id, name, email, mobile, gender);
		this.specialization = specialization;
		this.experience = experience;
		this.degrees = degrees;
		this.salary = salary;
	}

	public Doctor(String name, String email, String mobile, String gender, String specialization, int experience,
			String degrees, double salary) {
		super(name, email, mobile, gender);
		this.specialization = specialization;
		this.experience = experience;
		this.degrees = degrees;
		this.salary = salary;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDegrees() {
		return degrees;
	}

	public void setDegrees(String degrees) {
		this.degrees = degrees;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	@Override
	public String toString() {
		return "Doctor [ " + super.toString() + " specialization=" + specialization + ", experience=" + experience
				+ ", degrees=" + degrees + ", salary=" + salary + "]";
	}

}
