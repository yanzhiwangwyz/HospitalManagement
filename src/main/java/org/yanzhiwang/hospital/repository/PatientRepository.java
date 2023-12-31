package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yanzhiwang.hospital.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
