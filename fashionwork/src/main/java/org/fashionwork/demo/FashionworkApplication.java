package org.fashionwork.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableCaching
public class FashionWorkApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FashionWorkApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FashionWorkApplication.class, args);
    }
}
