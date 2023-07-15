package org.yanzhiwang.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.yanzhiwang.hospital.service.PatientService;
import org.yanzhiwang.hospital.model.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

public class PatientController {
    @Autowired
    private PatientService patientService;

    public String displayAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients";
    }
    // public ModelAndView displayAllPatients() {
    // List<Patient> patients = patientService.getAllPatients();
    // ModelAndView mav = new ModelAndView("patients");
    // mav.addObject("patients", patients);
    // return mav;
    // }
}
