package org.yanzhiwang.hospital.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;

// Reference for lombok 
// https://www.javaguides.net/2019/03/project-lombok-getter-setter-and-constructor-example.html
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
        @JoinTable(name = "patient_department", joinColumns = {
                        @JoinColumn(name = "patient_id") }, inverseJoinColumns = {
                                        @JoinColumn(name = "department_id") })
        private Set<Department> departments = new HashSet<Department>();
        // many-to-many relationship between patient and hospital
        // Any CRUD operation on the patient side will affect hospital side
        @ManyToMany(cascade = { CascadeType.ALL })
        // The owning side is patient so use @JoinTable in patient class
        @JoinTable(name = "patient_hospital", joinColumns = { @JoinColumn(name = "patient_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "hospital_id") })
        private Set<Hospital> hospitals = new HashSet<Hospital>();


        public Patient(String name, String description) {
                this.name = name;
                this.description = description;
        }
        
        public void removeHospital(Hospital hospital) {
                this.hospitals.remove(hospital);
                hospital.getPatients().remove(hospital);
        }

        public void addHospital(Hospital hospital) {
                this.hospitals.add(hospital);
                hospital.getPatients().add(this);
        }

        public void removeDepartment(Department department) {
                this.departments.remove(department);
                department.getPatients().remove(department);
        }

        public void addDepartment(Department department) {
                this.departments.add(department);
                department.getPatients().add(this);
        }

        public void removeDoctor(Doctor doctor) {
                this.doctors.remove(doctor);
                doctor.getPatients().remove(doctor);
        }

        public void addDoctor(Doctor doctor) {
                this.doctors.add(doctor);
                doctor.getPatients().add(this);
        }
}
