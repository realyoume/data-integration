package com.jw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JWCApplication {

    public static void main(String[] args) {
        SpringApplication.run(JWCApplication.class, args);
    }

}
