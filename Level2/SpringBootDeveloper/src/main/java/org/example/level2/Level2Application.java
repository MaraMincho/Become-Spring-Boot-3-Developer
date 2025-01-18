package org.example.level2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication

public class Level2Application {
    public static void main(String[] args) {
        System.out.println("Client ID: " + clientId);
        SpringApplication.run(Level2Application.class, args);

    }
    public Level2Application(@Value("${OAUTH2_CLIENT_ID}") String clientId) {
        Level2Application.clientId = clientId;
    }
    private static String clientId;
}


