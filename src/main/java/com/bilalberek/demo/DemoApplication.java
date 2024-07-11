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
		//Object studentOne = context.getBean("provideStudent");

		NetworkService service = context.getBean(NetworkService.class);
		System.out.println(service.getOsName());
		System.out.println(service.getJavaVersion());
		System.out.println(service.readProperty());


		System.out.println(service.SayHelloToTheStudent()); // HelloMehmet


		/**
		 * 	Student studentTwo  = context.getBean("emptyConstStudent", Student.class);
		 * 		System.out.println(((Student) studentTwo).getName());
		 * 		System.out.println(((Student) studentTwo).getSurname());
		 * 		System.out.println(((Student) studentTwo).getStudentId());
		 *
		 */

		/**
		 * 	Student studentOne = context.getBean(Student.class);
		 * 		System.out.println(((Student) studentOne).getName());
		 * 		System.out.println(((Student) studentOne).getSurname());
		 * 		System.out.println(((Student) studentOne).getStudentId());
		 */

	}

	// @Bean(value = "provideStudent")
	public Student provideStudent(){
		 return new Student("Ahmet", "çelik",22232242);
	}

}

