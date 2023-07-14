package org.yanzhiwang.hospital.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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

// Reference for lombok 
// https://www.javaguides.net/2019/03/project-lombok-getter-setter-and-constructor-example.html
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
