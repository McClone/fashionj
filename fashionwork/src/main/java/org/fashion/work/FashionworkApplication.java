package org.fashion.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FashionworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FashionworkApplication.class, args);
    }
}
