package org.fashionwork;

import org.fashionwork.springboot.shiro.EnableWebShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWebShiro
public class SpringBootShiroStartExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShiroStartExampleApplication.class, args);
    }
}
