package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yanzhiwang.hospital.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}