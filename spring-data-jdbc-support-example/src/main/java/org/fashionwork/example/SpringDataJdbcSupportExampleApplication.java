package org.fashionwork.example;

import org.fashionwork.jdbc.EnableSpringDataJdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSpringDataJdbc
public class SpringDataJdbcSupportExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcSupportExampleApplication.class, args);
    }
}
