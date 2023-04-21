package com.springboot.compositekey.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

//spring annotation
@Configuration
public class FakerConfig {

    //creating an faker object for autowired injection
    @Bean
    public Faker faker() {
        return new Faker(new Locale("en-US"));
    }
}
