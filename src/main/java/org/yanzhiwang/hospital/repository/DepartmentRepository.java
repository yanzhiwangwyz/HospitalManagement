package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yanzhiwang.hospital.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
