package com.codegnan.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.codegnan.exception.InvalidDateFormatException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields from JSON response
public class Patient extends Person {

    @JsonFormat(pattern = "yyyy-MM-dd") // Ensure correct date format during serialization
    private Date regDate;

    private int age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Visit> visits;

    public Patient() {
        super();
    }

    public Patient(int id, String name, String email, String mobile, String gender, String strRegDate, int age) throws InvalidDateFormatException {
        super(id, name, email, mobile, gender);
        setRegDate(strRegDate); // Set the registration date using the provided string
        this.age = age;
    }

    public Patient(String name, String email, String mobile, String gender, String strRegDate, int age) throws InvalidDateFormatException {
        super(name, email, mobile, gender);
        setRegDate(strRegDate); // Set the registration date using the provided string
        this.age = age;
    }

    // Get the registration date as a formatted string (dd-MM-yyyy)
    public String getRegDate() {
        if (regDate == null) {
            return null; // Return null if regDate is not set
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(regDate);
    }

    // Set the registration date from a string (dd-MM-yyyy format)
    public void setRegDate(String strRegDate) throws InvalidDateFormatException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.regDate = simpleDateFormat.parse(strRegDate);
        } catch (ParseException e) {
            throw new InvalidDateFormatException(e); // Throw custom exception if the date format is invalid
        }
    }

    // Getters and setters for other fields
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strRegDate = regDate == null ? "N/A" : simpleDateFormat.format(regDate); // Handle null date gracefully
        return "Patient [ " + super.toString() + " regDate=" + strRegDate + ", age=" + age + "]";
    }
}
