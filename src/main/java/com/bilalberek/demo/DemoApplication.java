package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Collections;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(DemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","test"));
		var context = app.run(args);
		NetworkService service = context.getBean(NetworkService.class);
		Student student = context.getBean(Student.class);

		System.out.println(student.getName());
		System.out.println(service.getMyCustomHeight());
		System.out.println(service.getMyCustomId());
		System.out.println(service.getMyCustomWeight());
		System.out.println(service.getMyCustomProperty());
		System.out.println(service.getMyCustomSpecialDev());
	}


}

