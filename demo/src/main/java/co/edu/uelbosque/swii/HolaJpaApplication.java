package co.edu.uelbosque.swii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories(basePackages="co.edu.uelbosque.swii.persistencia")
public class HolaJpaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HolaJpaApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HolaJpaApplication.class);
    }
}
