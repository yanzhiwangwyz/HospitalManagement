package org.yanzhiwang.hospital.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;

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
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	// The inverse side is doctor
	// It indicates that the relationship is mapped
	@ManyToMany(mappedBy = "doctors", cascade = { CascadeType.ALL })
	private Set<Patient> patients = new HashSet<Patient>(); 

	public Doctor(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
