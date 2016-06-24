package org.fashion.work;

import org.fashion.work.shiro.ApplicationContextUtils;
import org.fashion.work.shiro.EnableWebShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableWebShiro
public class FashionworkApplication {

    @Bean
    public ApplicationContextUtils applicationContextUtils() {
        return new ApplicationContextUtils();
    }

    public static void main(String[] args) {
        SpringApplication.run(FashionworkApplication.class, args);
    }
}
