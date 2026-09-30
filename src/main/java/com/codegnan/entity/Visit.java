package com.codegnan.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.codegnan.exception.InvalidDateFormatException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Visit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@ManyToOne
	@JoinColumn(name = "p_id")
	Patient patient;
	@ManyToOne
	@JoinColumn(name="d_id")
	Doctor doctor;
	Date date;
	String disease;
	double weight;
	double temperature;
	double bp;
	String modeOfPayment;
	public Visit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Visit(int id, String strDate, String disease, double weight, double temperature, double bp,
			String modeOfPayment) throws InvalidDateFormatException {
		super();
		this.id = id;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.date = simpleDateFormat.parse(strDate);
		} catch (ParseException e) {
			throw new InvalidDateFormatException(e);
		}
		this.disease = disease;
		this.weight = weight;
		this.temperature = temperature;
		this.bp = bp;
		this.modeOfPayment = modeOfPayment;
	}
	public Visit(String strDate, String disease, double weight, double temperature, double bp, String modeOfPayment) throws InvalidDateFormatException {
		super();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.date = simpleDateFormat.parse(strDate);
		} catch (ParseException e) {
			throw new InvalidDateFormatException(e);
		}
		this.disease = disease;
		this.weight = weight;
		this.temperature = temperature;
		this.bp = bp;
		this.modeOfPayment = modeOfPayment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(String strDate) throws InvalidDateFormatException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.date = simpleDateFormat.parse(strDate);
		} catch (ParseException e) {
			throw new InvalidDateFormatException(e);
		}
	}
	public String getDisease() {
		return disease;
	}
	public void setDesease(String disease) {
		this.disease = disease;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getBp() {
		return bp;
	}
	public void setBp(double bp) {
		this.bp = bp;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = simpleDateFormat.format(date);
		return "Visit [id=" + id + ", date=" + strDate + ", disease=" + disease + ", weight=" + weight + ", temperature="
				+ temperature + ", bp=" + bp + ", modeOfPayment=" + modeOfPayment + "]";
	}

}
