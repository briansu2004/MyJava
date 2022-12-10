package com.sutek.myskillsinventoryspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MySkillsInventorySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySkillsInventorySpringBootApplication.class, args);
	}

}
