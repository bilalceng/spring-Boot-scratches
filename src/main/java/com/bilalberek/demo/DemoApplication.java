package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(DemoApplication.class, args);
		//Object studentOne = context.getBean("provideStudent");
		Student studentOne = context.getBean(Student.class);



		System.out.println(((Student) studentOne).getName());
		System.out.println(((Student) studentOne).getSurname());
		System.out.println(((Student) studentOne).getStudentId());
	}

	// @Bean(value = "provideStudent")
	public Student provideStudent(){
		 return new Student("Ahmet", "çelik",22232242);
	}

}

