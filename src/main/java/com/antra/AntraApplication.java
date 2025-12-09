package com.antra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AntraApplication {

    public static void main(String[] args) {
        SpringApplication.run(AntraApplication.class, args);
    }

}
