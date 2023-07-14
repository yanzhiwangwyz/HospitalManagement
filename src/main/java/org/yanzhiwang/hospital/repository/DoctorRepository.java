package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yanzhiwang.hospital.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
