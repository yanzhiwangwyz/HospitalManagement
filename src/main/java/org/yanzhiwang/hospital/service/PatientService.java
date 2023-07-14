package org.yanzhiwang.hospital.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.yanzhiwang.hospital.repository.PatientRepository;
import org.yanzhiwang.hospital.model.Patient;
import java.util.*;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
        patientRepository.deleteById(id);
        } else {
        throw new RuntimeException("Patient not found");
        }
        // Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        // patientRepository.deleteById(patient.getPatientId());
    }
}
