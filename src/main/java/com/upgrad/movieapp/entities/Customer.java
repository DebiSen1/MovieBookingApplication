package com.upgrad.movieapp.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CustomerDetails")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    @Column(name = "first_name",length = 20,nullable = false)
    private String firstName;
    @Column(name="last_name",length=20,nullable = true)
    private String lastName;
    @Column(name = "basic_salary")
    private double salary;
    @Column(name = "dob")
    private LocalDateTime dateOfBirth;
    
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Customer [cid=" + cid + ", dateOfBirth=" + dateOfBirth + ", firstName=" + firstName + ", lastName="
                + lastName + ", salary=" + salary + "]";
    }
    
}
