package co.edu.uelbosque.swii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="co.edu.uelbosque.swii.persistencia")
public class HolaJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaJpaApplication.class, args);
	}
}
