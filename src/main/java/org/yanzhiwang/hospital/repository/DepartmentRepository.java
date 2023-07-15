package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yanzhiwang.hospital.model.Department;
import java.util.*;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public List<Department> getAllDepartment();

    public Department getDepartmentById(Long id);

    public Department saveDepartment(Department department);

    public void updateDepartment(Department department);

    public void deleteDepartmentById(Long id);
}