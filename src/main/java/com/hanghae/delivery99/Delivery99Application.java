package com.hanghae.delivery99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Delivery99Application {

    public static void main(String[] args) {
        SpringApplication.run(Delivery99Application.class, args);
    }

}
