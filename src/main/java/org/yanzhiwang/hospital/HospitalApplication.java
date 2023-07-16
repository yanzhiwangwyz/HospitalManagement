package org.yanzhiwang.hospital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yanzhiwang.hospital.model.*;
import org.yanzhiwang.hospital.service.PatientService;
import org.yanzhiwang.hospital.util.CreateDummyData;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(PatientService patientService) {
		return args -> {
			CreateDummyData createDummyData = new CreateDummyData(patientService);
			createDummyData.createDummyData();
		};
	}
}
