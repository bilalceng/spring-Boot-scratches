package com.bilalberek.demo;

import com.bilalberek.demo.javaadvancedtopics.DoughType;
import com.bilalberek.demo.javaadvancedtopics.Pizza;
import com.bilalberek.demo.javaadvancedtopics.WaterType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Pizza tomatoPizza = new Pizza.Builder(DoughType.CORN , true, WaterType.BOTTLE_WATER )
				.tomato(true)
				.pepper(true)
				.build();

		System.out.println(tomatoPizza);

	}
}
