package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yanzhiwang.hospital.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    
}
