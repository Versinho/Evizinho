package Evizinhotest2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "Evizinhotest2")
@EntityScan("Evizinhotest2.model")
@EnableJpaRepositories("Evizinhotest2.repository")
@ComponentScan(basePackages={"Evizinhotest2.*"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
