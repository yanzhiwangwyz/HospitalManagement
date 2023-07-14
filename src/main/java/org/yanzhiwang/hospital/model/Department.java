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
	
	public Department(String name) {
		this.name = name;
	}
}
