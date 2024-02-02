package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//Audit機能有効化
@EnableJpaAuditing
@SpringBootApplication
public class SpringMvcApplication {

 public static void main(String[] args) {
     SpringApplication.run(SpringMvcApplication.class, args);
 }

}