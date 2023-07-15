package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yanzhiwang.hospital.model.Hospital;
import java.util.*;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    public List<Hospital> getAllHospitals();

    public Hospital getHospitalById(Long id);

    public Hospital saveHospital(Hospital hospital);

    public void updateHospital(Hospital hospital);

    public void deleteHospitalById(Long id);
}
