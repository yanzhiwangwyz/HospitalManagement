package org.yanzhiwang.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.yanzhiwang.hospital.service.PatientService;
import org.yanzhiwang.hospital.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public ModelAndView displayAllPatients() {
        List<Patient> patientList = patientService.getAllPatients();
        ModelAndView mav = new ModelAndView("patients_page");
        mav.addObject("patientList", patientList);
        return mav;
    }

    @GetMapping("/patient-profile/{id}")
    public ModelAndView displayPatientById(@PathVariable("id") Long id) {
        Patient patientObject = patientService.getPatientById(id);
        ModelAndView mav = new ModelAndView("patient_profile_page");
        mav.addObject("patientObject", patientObject);
        return mav;
    }
}
