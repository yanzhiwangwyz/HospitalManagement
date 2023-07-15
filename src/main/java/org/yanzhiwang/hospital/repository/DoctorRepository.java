package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yanzhiwang.hospital.model.Doctor;
import java.util.*;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    public List<Doctor> getAllDoctor();

    public Doctor getDoctorById(Long id);

    public Doctor saveDoctor(Doctor doctor);

    public void updateDoctor(Doctor doctor);

    public void deleteDoctorById(Long id);
}
