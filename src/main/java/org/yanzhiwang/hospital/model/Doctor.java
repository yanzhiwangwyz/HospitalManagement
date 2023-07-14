package org.yanzhiwang.hospital.model;

import jakarta.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")

public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	// The inverse side is doctor 
	// It indicates that the relationship is mapped 
	@ManyToMany(mappedBy = "doctors", cascade = { CascadeType.ALL })
	private Set<Patient> patients = new HashSet<Patient>();
}
