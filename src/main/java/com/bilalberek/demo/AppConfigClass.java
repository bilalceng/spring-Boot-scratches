package com.bilalberek.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigClass {
     @Bean
    public Student provideStudent(){ // Spring use method name as bean name by default
        return new Student("Ahmet", "çelik",22232242);
    }

}
