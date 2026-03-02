package com.example.fakecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // for created/updated dates in tables and entities
public class FakeCommerceApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));
        System.out.println("Server PORT: " + System.getProperty("SERVER_PORT"));
        SpringApplication.run(FakeCommerceApplication.class, args);
    }

}
