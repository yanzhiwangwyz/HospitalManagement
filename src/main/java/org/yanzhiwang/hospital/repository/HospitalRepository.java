package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yanzhiwang.hospital.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
