package com.jw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JWAApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWAApplication.class, args);
    }

}
