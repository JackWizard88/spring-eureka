package com.geekbrains.krylov.spring_eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EurekaProductClientApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProductClientApp.class, args);
    }
}
