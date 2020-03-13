package com.bugbean.studydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class StudydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudydemoApplication.class, args);
    }

}
