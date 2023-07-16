package org.yanzhiwang.hospital.util;

import org.springframework.stereotype.Component;
import org.yanzhiwang.hospital.model.*;
import org.yanzhiwang.hospital.service.PatientService;

@Component
public class CreateDummyData {

    private final PatientService patientService;

    public CreateDummyData(PatientService patientService) {
        this.patientService = patientService;
    }

    public void createDummyData() {
        Patient patient1 = new Patient("patient1", "M", 87, "example1 street", "123-456-7890",
                "Patient Description 1");
        Doctor doctor1 = new Doctor("doctor1", "doctor description 1");
        Department department1 = new Department("department1");
        Hospital hospital1 = new Hospital("hospital1");
        // Add associations between patient and related entities manually
        patient1.getDoctors().add(doctor1);
        patient1.getDepartments().add(department1);
        patient1.getHospitals().add(hospital1);
        patientService.registerPatient(patient1);

        Patient patient2 = new Patient("patient2", "F", 32, "example2 street", "123-456-7890",
                "Patient Description 2");
        Doctor doctor2 = new Doctor("doctor2", "doctor description 2");
        Department department2 = new Department("department2");
        Hospital hospital2 = new Hospital("hospital2");
        // Add associations between patient and related entities manually
        patient2.getDoctors().add(doctor2);
        patient2.getDepartments().add(department2);
        patient2.getHospitals().add(hospital2);
        patientService.registerPatient(patient2);

        Patient patient3 = new Patient("patient3", "M", 45, "example3 street", "123-456-7890",
                "Patient Description 3");
        Doctor doctor3 = new Doctor("doctor3", "doctor description 3");
        Department department3 = new Department("department3");
        Hospital hospital3 = new Hospital("hospital3");
        // Add associations between patient and related entities manually
        patient3.getDoctors().add(doctor3);
        patient3.getDepartments().add(department3);
        patient3.getHospitals().add(hospital3);
        patientService.registerPatient(patient3);
    }
}

