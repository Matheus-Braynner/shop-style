package io.github.matheusbraynner.ms_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MsCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCustomerApplication.class, args);
	}

}
