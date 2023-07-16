package org.yanzhiwang.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yanzhiwang.hospital.model.Hospital;
import org.yanzhiwang.hospital.service.HospitalService;

import java.util.*;

@Controller
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/hospitals")
    public ModelAndView displayAllHospitals() {
        List<Hospital> hospitalList = hospitalService.getAllHospitals();
        ModelAndView mav = new ModelAndView("hospitalsPage");
        mav.addObject("hospitalList", hospitalList);
        return mav;
    }

    @GetMapping("/remove-hospital-confirm/{id}")
    public ModelAndView displayRemoveHospitalConfirm(@PathVariable("id") Long id) {
        Hospital hospitalObject = hospitalService.getHospitalById(id);
        ModelAndView mav = new ModelAndView("hospitalDeleteConfirmationPage");
        mav.addObject("hospitalObject", hospitalObject);
        return mav;
    }

    @GetMapping("/remove-hospital/{id}")
    public ModelAndView removeHospital(@PathVariable("id") Long id) {
        hospitalService.deleteHospitalById(id);
        ModelAndView mav = new ModelAndView("hospitalsPage");
        mav.addObject("hospitalList", hospitalService.getAllHospitals());
        return mav;
    }

    @GetMapping("/update-hospital/{id}")
    public ModelAndView updateHospital(@PathVariable("id") Long id) {
        Hospital hospitalObject = hospitalService.getHospitalById(id);
        ModelAndView mav = new ModelAndView("hospitalUpdatePage");
        mav.addObject("hospitalObject", hospitalObject);
        return mav;
    }

    @PostMapping("/save-hospital-update/{id}")
    public ModelAndView saveHospitalUpdate(@PathVariable("id") Long id, Hospital updatedHospital) {
        // Get the existing hospital by ID
        Hospital existingHospital = hospitalService.getHospitalById(id);
        // Update the fields of the existing hospital with the new values
        existingHospital.setName(updatedHospital.getName());
        // Save the updated hospital
        hospitalService.updateHospital(existingHospital);
        ModelAndView mav = new ModelAndView("hospitalsPage");
        mav.addObject("hospitalList", hospitalService.getAllHospitals());
        return mav;
    }

    @GetMapping("/add-hospital")
    public ModelAndView addHospital(Hospital hospitalObject) {
        ModelAndView mav = new ModelAndView("hospitalAddPage");
        mav.addObject("hospitalObject", hospitalObject);
        return mav;
    }

    @PostMapping("/save-add-hospital")
    public ModelAndView saveAddHospital(Hospital hospitalObject) {
        hospitalService.addHospital(hospitalObject);
        ModelAndView mav = new ModelAndView("hospitalsPage");
        mav.addObject("hospitalList", hospitalService.getAllHospitals());
        return mav;
    }
}

