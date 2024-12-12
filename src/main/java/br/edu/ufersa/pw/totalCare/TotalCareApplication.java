package br.edu.ufersa.pw.totalCare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class TotalCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TotalCareApplication.class, args);
	}

	@GetMapping("/")
	public String helloWorld () {
		return "Hello World";
	}
	

}
