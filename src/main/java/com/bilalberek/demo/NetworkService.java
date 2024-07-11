package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NetworkService {
    @Autowired
    @Qualifier("provideStudent2")// field injection.
   private  Student student;

     // Constructor injection

       public NetworkService(Student student) {
             this.student = student;
         }


    public String SayHelloToTheStudent(){
        return "hello" + student.getName();
    }
}
