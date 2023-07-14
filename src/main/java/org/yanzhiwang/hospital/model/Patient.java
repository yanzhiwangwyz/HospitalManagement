package org.yanzhiwang.hospital.model;

import jakarta.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;
    @Column(name = "description", length = 100, nullable = false)
	private String description; 
}
