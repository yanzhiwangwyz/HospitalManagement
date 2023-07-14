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
@Table(name = "department")

public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	@Column(name = "name", length = 100, nullable = false, unique = true)
	private String name;
	// The inverse side is department
	// It indicates that the relationship is mapped
	@ManyToMany(mappedBy = "departments", cascade = { CascadeType.ALL })
	private Set<Patient> patients = new HashSet<Patient>();
}
