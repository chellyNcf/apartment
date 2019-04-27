package com.luoying.apartment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ServletComponentScan
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.luoying.apartment.dao")
public class ApartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApartmentApplication.class, args);
    }

}
