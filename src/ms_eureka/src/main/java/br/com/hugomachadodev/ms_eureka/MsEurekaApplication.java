package br.com.hugomachadodev.ms_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class MsEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaApplication.class, args);
	}

}
