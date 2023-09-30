
package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.domain.User;
import com.example.demo.service.UserCanUse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsonToDatabase {


	public static void main(String[] args) {
		SpringApplication.run(JsonToDatabase.class, args);
	}

	@Bean
	CommandLineRunner runner(UserCanUse userService){
	    return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<User>> typeReference = new TypeReference<>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
			try {
				List<User> users = mapper.readValue(inputStream,typeReference);
				userService.save(users);
				System.out.println("Users id, name and email are saved now!");
			} catch (IOException e){
				System.out.println("Could not save the user!: " + e.getMessage());
			}
	    };
	}
}