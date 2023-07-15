package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yanzhiwang.hospital.model.Patient;
import java.util.*;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> getAllPatients();

    public Patient getPatientById(Long id);

    public Patient savePatient(Patient patient);

    public void updatePatient(Patient patient);

    public void deletePatientById(Long id);
}
