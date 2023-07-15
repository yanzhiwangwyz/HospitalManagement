package org.yanzhiwang.hospital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yanzhiwang.hospital.model.*;
import org.yanzhiwang.hospital.service.PatientService;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(PatientService patientService) {
		return (args) -> {
			Patient patient1 = new Patient("patient1", "M", 87, "Patient Description 1");
			Doctor doctor1 = new Doctor("doctor1", "doctor description 1");
			Department department1 = new Department("department1");
			Hospital hospital1 = new Hospital("hospital1");
			patient1.addDoctor(doctor1);
			patient1.addDepartment(department1);
			patient1.addHospital(hospital1);
			patientService.savePatient(patient1);

			Patient patient2 = new Patient("patient2", "F", 23, "Patient Description 2");
			Doctor doctor2 = new Doctor("doctor2", "doctor description 2");
			Department department2 = new Department("department2");
			Hospital hospital2 = new Hospital("hospital2");
			patient2.addDoctor(doctor2);
			patient2.addDepartment(department2);
			patient2.addHospital(hospital2);
			patientService.savePatient(patient2);

			Patient patient3 = new Patient("patient3", "M", 45, "Patient Description 3");
			Doctor doctor3 = new Doctor("doctor3", "doctor description 3");
			Department department3 = new Department("department3");
			Hospital hospital3 = new Hospital("hospital3");
			patient3.addDoctor(doctor3);
			patient3.addDepartment(department3);
			patient3.addHospital(hospital3);
			patientService.savePatient(patient3);
		};
	}
}
