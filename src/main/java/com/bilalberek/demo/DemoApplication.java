package com.bilalberek.demo;


import com.bilalberek.demo.javaadvancedtopics.factorydesignpattern.Notification;
import com.bilalberek.demo.javaadvancedtopics.factorydesignpattern.NotificationFactory;
import com.bilalberek.demo.javaadvancedtopics.factorydesignpattern.NotificationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class,args);

		NotificationFactory factory = new NotificationFactory();

		Notification smsNotification = factory.createNotification(NotificationType.SMS_TYPE);

		System.out.println(smsNotification.sendNotification("how are doing"));

 	}
}
