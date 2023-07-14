package org.yanzhiwang.hospital.model;

import jakarta.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;
    @Column(name = "description", length = 100, nullable = false)
    private String description;
    // Reference for man-to-many relationship
    // https://www.baeldung.com/hibernate-many-to-many
    // many-to-many relationship between patient and doctor
    // Any CRUD operation on the patient side will affect doctor side
    @ManyToMany(cascade = { CascadeType.ALL })
    // The owning side is patient so use @JoinTable in patient class
    @JoinTable(name = "patient_doctor", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = {
            @JoinColumn(name = "doctor_id") })
    private Set<Doctor> doctors = new HashSet<Doctor>();
    // many-to-many relationship between patient and department 
    // Any CRUD operation on the patient side will affect department side 
    @ManyToMany(cascade = { CascadeType.ALL }) 
    // The owning side is patient so use @JoinTable in patient class 
    @JoinTable(name = "patient_department", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = {
            @JoinColumn(name = "department_id") })
    private Set<Department> departments = new HashSet<Department>();
    // many-to-many relationship between patient and hospital 
    // Any CRUD operation on the patient side will affect hospital side 
    @ManyToMany(cascade = { CascadeType.ALL })
    // The owning side is patient so use @JoinTable in patient class
    @JoinTable(name = "patient_hospital", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = {
            @JoinColumn(name = "hospital_id") })
    private Set<Hospital> hospitals = new HashSet<Hospital>();
}
