package org.fashion.work;

import org.fashion.work.shiro.EnableWebShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWebShiro
public class FashionworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FashionworkApplication.class, args);
    }
}
