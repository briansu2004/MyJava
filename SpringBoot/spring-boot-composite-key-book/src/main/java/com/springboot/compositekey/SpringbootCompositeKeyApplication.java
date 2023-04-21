package com.springboot.compositekey;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// lombok annotation
@Slf4j
// spring annotation
@SpringBootApplication
public class SpringbootCompositeKeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCompositeKeyApplication.class, args);
		log.info("Springboot and composite key application is started successfully.");
	}
}
