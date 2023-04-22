package com.sutek;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) throws IOException, JsonPatchException {
        InputStream jsonInput = App.class.getResourceAsStream("/example.json");

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        JsonNode jsonNode = objectMapper.readTree(jsonInput);

        Person person = objectMapper.treeToValue(jsonNode, Person.class);

        System.out.println("(Parsing JSON)");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());
        System.out.println("BirthDate: " + person.getBirthDate());


        System.out.println("");
        System.out.println("(JsonMergePatching)");


        // Define the original JSON object
        String originalJson = "{ \"name\": \"John\", \"age\": 30 }";
        System.out.println("Original JSON: " + originalJson);

        // Define the patch to be applied
        String patchJson = "{ \"age\": 31 }";
        System.out.println("Patch JSON: " + patchJson);

        // Create an ObjectMapper to read the patch JSON into a JsonNode
        // ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patchNode = objectMapper.readTree(patchJson);

        // Create a JsonMergePatch object from the patch JsonNode
        JsonMergePatch patch = JsonMergePatch.fromJson(patchNode);

        // Read the original JSON into a JsonNode
        JsonNode originalNode = objectMapper.readTree(originalJson);

        // Apply the patch to the original JSON object
        JsonNode updatedNode = patch.apply(originalNode);

        // Convert the updated JsonNode back to a JSON string and print it to the console
        String updatedJson = objectMapper.writeValueAsString(updatedNode);
        System.out.println("Updated JSON: " + updatedJson);
    }
}
