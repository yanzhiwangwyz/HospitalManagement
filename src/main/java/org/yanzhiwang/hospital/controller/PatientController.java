package org.yanzhiwang.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.yanzhiwang.hospital.service.PatientService;
import org.yanzhiwang.hospital.model.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    // @GetMapping("/patients")
    // public String displayAllPatients(Model model) {
    //     List<Patient> patientList = patientService.getAllPatients();
    //     model.addAttribute("patientList", patientList);
    //     return "patients_page";
    // }
    
    @GetMapping("/patients")
    public ModelAndView displayAllPatients() {
    List<Patient> patientList = patientService.getAllPatients();
    ModelAndView mav = new ModelAndView("patients_page");
    mav.addObject("patientList", patientList);
    return mav;
    }
}
