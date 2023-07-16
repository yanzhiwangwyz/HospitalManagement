package org.yanzhiwang.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.yanzhiwang.hospital.service.*;
import org.yanzhiwang.hospital.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/patients")
    public ModelAndView displayAllPatients() {
        List<Patient> patientList = patientService.getAllPatients();
        ModelAndView mav = new ModelAndView("patientsPage");
        mav.addObject("patientList", patientList);
        return mav;
    }

    @GetMapping("/patient-profile/{id}")
    public ModelAndView displayPatientById(@PathVariable("id") Long id) {
        Patient patientObject = patientService.getPatientById(id);
        ModelAndView mav = new ModelAndView("patientProfilePage");
        mav.addObject("patientObject", patientObject);
        return mav;
    }

    @GetMapping("/remove-patient-confirm/{id}")
    public ModelAndView removePatientConfirmation(@PathVariable("id") Long id) {
        Patient patientObject = patientService.getPatientById(id);
        ModelAndView mav = new ModelAndView("patientsDeleteConfirmationPage");
        mav.addObject("patientObject", patientObject);
        return mav;
    }

    @GetMapping("/remove-patient/{id}")
    public ModelAndView removePatient(@PathVariable("id") Long id) {
        patientService.deletePatientById(id);
        ModelAndView mav = new ModelAndView("patientsPage");
        mav.addObject("patientList", patientService.getAllPatients());
        return mav;
    }

    // @PostMapping("/remove-patient/{id}")
    // public ModelAndView removePatient(@PathVariable("id") Long id) {
    // patientService.deletePatientById(id);
    // ModelAndView mav = new ModelAndView("patients_page");
    // mav.addObject("patientList", patientService.getAllPatients());
    // return mav;
    // }

    @GetMapping("/update-patient/{id}")
    public ModelAndView updatePatient(@PathVariable("id") Long id) {
        Patient patientObject = patientService.getPatientById(id);
        ModelAndView mav = new ModelAndView("patientUpdatePage");
        mav.addObject("patientObject", patientObject);
        mav.addObject("doctorList", doctorService.getAllDoctors());
        mav.addObject("departmentList", departmentService.getAllDepartments());
        mav.addObject("hospitalList", hospitalService.getAllHospitals());
        return mav;
    }

    @PostMapping("/save-update/{id}")
    public ModelAndView saveUpdate(@PathVariable("id") Long id, Patient updatedPatient) {
        // Get the existing patient by ID
        Patient existingPatient = patientService.getPatientById(id);

        // Update the fields of the existing patient with the new values
        existingPatient.setName(updatedPatient.getName());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setAge(updatedPatient.getAge());
        existingPatient.setAddress(updatedPatient.getAddress());
        existingPatient.setContact(updatedPatient.getContact());
        existingPatient.setDescription(updatedPatient.getDescription());
        existingPatient.setDoctors(updatedPatient.getDoctors());
        existingPatient.setDepartments(updatedPatient.getDepartments());
        existingPatient.setHospitals(updatedPatient.getHospitals());

        // Save the updated patient
        patientService.updatePatient(existingPatient);
        // If use patientService.updatePatient(updatedPatient), it display two patients
        // with the same name in the patientsPage
        // patientService.updatePatient(updatedPatient);

        ModelAndView mav = new ModelAndView("patientsPage");
        mav.addObject("patientList", patientService.getAllPatients());
        return mav;
    }

    @GetMapping("/register-patient")
    public ModelAndView registerPatient(Patient patient) {
        ModelAndView mav = new ModelAndView("patientAddPage");
        Patient patientObject = new Patient();
        mav.addObject("patientObject", patientObject);
        mav.addObject("doctorList", doctorService.getAllDoctors());
        mav.addObject("departmentList", departmentService.getAllDepartments());
        mav.addObject("hospitalList", hospitalService.getAllHospitals());
        return mav;
    }

    // save register
    @PostMapping("/save-register")
    public ModelAndView saveRegister(Patient patient) {
        patientService.registerPatient(patient);
        ModelAndView mav = new ModelAndView("patientsPage");
        mav.addObject("patientList", patientService.getAllPatients());
        return mav;
    }
}