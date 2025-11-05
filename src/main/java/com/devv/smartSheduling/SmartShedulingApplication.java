package com.devv.smartSheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for starting the SmartScheduling application.
 * <p>
 * This class runs the Spring Boot application and loads all configurations.
 * </p>
 */
@SpringBootApplication
public class SmartShedulingApplication {

    /**
     * Main method to start the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(SmartShedulingApplication.class, args);
	}

}
