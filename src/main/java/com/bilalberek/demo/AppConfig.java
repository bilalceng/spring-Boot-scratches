package com.bilalberek.demo;

import com.bilalberek.demo.dto.UserRegistrationDto;
import com.bilalberek.demo.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public User provideUser(){
        return new User();
    }

    @Bean
    @Scope("prototype")
    public UserRegistrationDto provideUserRegistrationDto(){
        return new UserRegistrationDto();
    }


}
