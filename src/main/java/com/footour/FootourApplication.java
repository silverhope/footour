package com.footour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

@SpringBootApplication
@EnableAutoConfiguration
public class FootourApplication {
//    private static final String PID_FILE = "footour.pid";

    public static void main(String[] args) {
//        final SpringApplication footourApplication = new SpringApplication(FootourApplication.class);
//        footourApplication.addListeners(new ApplicationPidFileWriter(PID_FILE));
//        footourApplication.run(args);
        SpringApplication.run(FootourApplication.class, args);
    }
}
