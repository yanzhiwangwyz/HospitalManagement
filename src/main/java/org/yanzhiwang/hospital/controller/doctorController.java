package org.yanzhiwang.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yanzhiwang.hospital.model.Doctor;
import org.yanzhiwang.hospital.service.DoctorService;

import java.util.*;

@Controller
public class doctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public ModelAndView displayAllDoctors() {
        List<Doctor> doctorList = doctorService.getAllDoctors();
        ModelAndView mav = new ModelAndView("doctorsPage");
        mav.addObject("doctorList", doctorList);
        return mav;
    }

    @GetMapping("/remove-doctor-confirm/{id}")
    public ModelAndView removeDoctorConfirm(@PathVariable("id") Long id) {
        Doctor doctorObject = doctorService.getDoctorById(id);
        ModelAndView mav = new ModelAndView("doctorDeleteConfirmationPage");
        mav.addObject("doctorObject", doctorObject);
        return mav;
    }

    @GetMapping("/remove-doctor/{id}")
    public ModelAndView removeDoctor(@PathVariable("id") Long id) {
        doctorService.deleteDoctorById(id);
        ModelAndView mav = new ModelAndView("doctorsPage");
        mav.addObject("doctorList", doctorService.getAllDoctors());
        return mav;
    }

    @GetMapping("/update-doctor/{id}")
    public ModelAndView updateDoctor(@PathVariable("id") Long id) {
        Doctor doctorObject = doctorService.getDoctorById(id);
        ModelAndView mav = new ModelAndView("doctorUpdatePage");
        mav.addObject("doctorObject", doctorObject);
        return mav;
    }

    @PostMapping("/save-doctor-update/{id}")
    public ModelAndView saveDoctorUpdate(@PathVariable("id") Long id, Doctor updatedDoctor) {
        // Get the existing doctor by ID
        Doctor existingDoctor = doctorService.getDoctorById(id);
        // Update the fields of the existing doctor with the new values
        existingDoctor.setName(updatedDoctor.getName());
        // Update other fields as needed

        // Save the updated doctor
        doctorService.updateDoctor(existingDoctor);

        ModelAndView mav = new ModelAndView("doctorsPage");
        mav.addObject("doctorList", doctorService.getAllDoctors());
        return mav;
    }

    @GetMapping("/add-doctor")
    public ModelAndView addDoctor(Doctor doctorObject) {
        ModelAndView mav = new ModelAndView("doctorAddPage");
        mav.addObject("doctorObject", doctorObject);
        return mav;
    }
}
