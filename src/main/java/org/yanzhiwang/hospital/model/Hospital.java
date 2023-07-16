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
@Table(name = "hospital")

public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    // The inverse side is hospital
    // It indicates that the relationship is mapped
    @ManyToMany(mappedBy = "hospitals", cascade = { CascadeType.ALL })
    private Set<Patient> patients = new HashSet<Patient>();

    public Hospital(String name) {
        this.name = name;
    }
}
