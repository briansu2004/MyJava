package com.sutek;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException {
        InputStream jsonInput = App.class.getResourceAsStream("/example.json");

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        JsonNode jsonNode = objectMapper.readTree(jsonInput);

        Person person = objectMapper.treeToValue(jsonNode, Person.class);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
        System.out.println("BirthDate: " + person.getBirthDate());
    }
}
