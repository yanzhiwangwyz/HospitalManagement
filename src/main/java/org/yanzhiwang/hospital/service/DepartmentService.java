package org.yanzhiwang.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yanzhiwang.hospital.repository.DepartmentRepository;
import org.yanzhiwang.hospital.model.Department;
import java.util.*;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new RuntimeException("Department not found");
        }
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Department not found");
        }
    }
}
