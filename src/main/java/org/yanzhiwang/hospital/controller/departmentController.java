package org.yanzhiwang.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.yanzhiwang.hospital.model.Department;
import org.yanzhiwang.hospital.service.DepartmentService;

import java.util.*;

@Controller
public class departmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ModelAndView displayAllDepartments() {
        List<Department> departmentList = departmentService.getAllDepartments();
        ModelAndView mav = new ModelAndView("departmentsPage");
        mav.addObject("departmentList", departmentList);
        return mav;
    }

    @GetMapping("/remove-department-confirm/{id}")
    public ModelAndView removeDepartmentConfirm(@PathVariable("id") Long id) {
        Department departmentObject = departmentService.getDepartmentById(id);
        ModelAndView mav = new ModelAndView("departmentDeleteConfirmationPage");
        mav.addObject("departmentObject", departmentObject);
        return mav;
    }

    @GetMapping("/remove-department/{id}")
    public ModelAndView removeDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentById(id);
        ModelAndView mav = new ModelAndView("departmentsPage");
        mav.addObject("departmentList", departmentService.getAllDepartments());
        return mav;
    }

    @GetMapping("/update-department/{id}")
    public ModelAndView updateDepartment(@PathVariable("id") Long id) {
        Department departmentObject = departmentService.getDepartmentById(id);
        ModelAndView mav = new ModelAndView("departmentUpdatePage");
        mav.addObject("departmentObject", departmentObject);
        return mav;
    }

    @PostMapping("/save-department-update/{id}")
    public ModelAndView saveDepartmentUpdate(@PathVariable("id") Long id, Department updatedDepartment) {
        // Get the existing department by ID
        Department existingDepartment = departmentService.getDepartmentById(id);
        // Update the fields of the existing department with the new values
        existingDepartment.setName(updatedDepartment.getName());
        // Save the updated department
        departmentService.updateDepartment(existingDepartment);
        ModelAndView mav = new ModelAndView("departmentsPage");
        mav.addObject("departmentList", departmentService.getAllDepartments());
        return mav;
    }

    @GetMapping("/add-department")
    public ModelAndView addDepartment(Department departmentObject) {
        ModelAndView mav = new ModelAndView("departmentAddPage");
        mav.addObject("departmentObject", departmentObject);
        return mav;
    }

    @PostMapping("/save-add-department")
    public ModelAndView saveDepartment(Department department) {
        departmentService.addDepartment(department);
        ModelAndView mav = new ModelAndView("departmentsPage");
        mav.addObject("departmentList", departmentService.getAllDepartments());
        return mav;
    }
}
