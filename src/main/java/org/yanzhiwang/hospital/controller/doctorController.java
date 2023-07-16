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


}

