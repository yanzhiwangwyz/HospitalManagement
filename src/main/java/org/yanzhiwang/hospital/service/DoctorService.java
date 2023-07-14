package org.yanzhiwang.hospital.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.yanzhiwang.hospital.repository.DoctorRepository;
import org.yanzhiwang.hospital.model.Doctor;
import java.util.*;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
            return doctor.get();
        } else {
            throw new RuntimeException("Doctor not found");
        }
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
