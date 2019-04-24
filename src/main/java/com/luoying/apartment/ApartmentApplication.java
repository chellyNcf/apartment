package com.luoying.apartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ServletComponentScan
//@EnableWebMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApartmentApplication.class, args);
    }

}
