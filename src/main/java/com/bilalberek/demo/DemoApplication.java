package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(DemoApplication.class, args);
		NetworkService service = context.getBean(NetworkService.class);

		System.out.println(service.getMyProperty());
		System.out.println(service.getMyProperty2());
		System.out.println(service.getIntProperty());

	}


}

