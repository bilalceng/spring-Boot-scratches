package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NetworkService {

    private  Student student;

    // field injection.

    /**
     *     @Autowired
     *     @Qualifier("provideStudent2")
     *    private  Student student;
     */

     // Constructor injection.
    /**
     *        public NetworkService(Student student) {
     *              this.student = student;
     *          }
     *
     */

    @Autowired
    public void injectDependencies(@Qualifier("provideStudent3") Student student){
        this.student = student;
    }

    public String SayHelloToTheStudent(){
        return "hello " + student.getName();
    }
}
