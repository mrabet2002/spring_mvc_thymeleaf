package ma.enset.jpa_hibernate;

import lombok.extern.slf4j.Slf4j;
import ma.enset.jpa_hibernate.entities.Patient;
import ma.enset.jpa_hibernate.entities.Role;
import ma.enset.jpa_hibernate.entities.User;
import ma.enset.jpa_hibernate.enums.RoleName;
import ma.enset.jpa_hibernate.services.interfaces.IPatientService;
import ma.enset.jpa_hibernate.services.interfaces.IUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Random;

@SpringBootApplication
@Slf4j
public class JpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			IPatientService patientService,
			IUserService userService
	) {
		return args -> {
			Random random = new Random();
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, 1970 + random.nextInt(55)); // 2024 - 1970 = 54
			calendar.set(Calendar.MONTH, random.nextInt(12));
			calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(28) + 1); // Assuming all months have 28 days for simplicity
//
//			Patient patient = new Patient();
//			patient.setNom("Yassine");
//			patient.setDateNaissance(calendar.getTime());
//			patient.setMalade(true);
//			patient.setScore(10);
//
//			log.info("Patient created: " + patientService.createPatient(patient));
//
			for (int i = 0; i < 10; i++) {
				Patient p = new Patient();
				p.setNom("Patient" + i);
				// Generate a random date between 1970 and 2024
				calendar.set(Calendar.YEAR, 1970 + random.nextInt(55)); // 2024 - 1970 = 54
				calendar.set(Calendar.MONTH, random.nextInt(12));
				calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(28) + 1); // Assuming all months have 28 days for simplicity
				p.setDateNaissance(calendar.getTime());

				p.setMalade(i % 2 == 0);
				p.setScore(10 + i);

				patientService.createPatient(p);
			}
//
//			log.info("Patients: " + patientService.getPatients());
//
//			log.info("Patients with 'Yassine' in their name: " + patientService.searchPatients("Yassine"));
//
//			log.info("Patient with id 1: " + patientService.getPatient(1L));
//
//			Patient patientToUpdate = patientService.getPatient(1L);
//			patientToUpdate.setNom("Yassine El Maalej");
//			patientService.updatePatient(1L, patientToUpdate);
//
//			log.info("Patient with id 1 after update: " + patientService.getPatient(1L));
//
//			patientService.deletePatient(1L);
//
//			log.info("Patients after deleting patient with id 1: " + patientService.getPatients());

			// Adding Users and Roles
//			User user = new User();
//			user.setName("Yassine El Maalej");
//			user.setUsername("yassine");
//			user.setPassword("1234");
//
//			userService.addUser(user);
//
//			log.info("User added: " + user);
//
//			log.info("Users: " + userService.getUsers());
//
//			Role role = new Role();
//			role.setRoleName(RoleName.ROLE_USER);
//			userService.addRole(role);
//
//			userService.addRoleToUser("yassine", "ROLE_USER");

		};
	}

}
