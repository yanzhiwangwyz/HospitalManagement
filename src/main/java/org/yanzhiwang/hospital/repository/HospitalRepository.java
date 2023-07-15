package org.yanzhiwang.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yanzhiwang.hospital.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
