package org.yanzhiwang.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yanzhiwang.hospital.repository.HospitalRepository;
import org.yanzhiwang.hospital.model.Hospital;
import java.util.*;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital getHospitalById(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            return hospital.get();
        } else {
            throw new RuntimeException("Hospital not found");
        }
    }

    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public void updateHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    public void deleteHospitalById(Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()) {
            hospitalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Hospital not found");
        }
    }
}
