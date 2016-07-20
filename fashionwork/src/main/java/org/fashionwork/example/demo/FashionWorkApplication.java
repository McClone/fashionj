package org.fashionwork.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableCaching
@EnableScheduling
public class FashionWorkApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FashionWorkApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FashionWorkApplication.class, args);
    }
}
