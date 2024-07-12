package com.bilalberek.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile("dev") make all beans in this config class to appear only dev profile
@Configuration
public class AppConfigClass {
    @Profile("dev") // make this bean in this config class to appear only dev profile.
    @Bean
    public Student provideStudent(){ // Spring use method name as bean name by default
        return new Student("Ahmet", "çelik",22232242);
    }
    @Profile("dev")
    @Bean
    public Student provideStudent2(){ // Spring use method name as bean name by default
        return new Student("Mehmet", "çelik",322312232);
    }

    //@Primary
    @Bean
    public Student provideStudent3(){ return  new Student("Bilal", "Berek", 34345453);
    }
}



