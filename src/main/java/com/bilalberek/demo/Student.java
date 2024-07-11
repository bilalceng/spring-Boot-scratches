package com.bilalberek.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component("emptyConstStudent") // with component keyword the Student class behave like bean and when call  it return empty constructor.
// can be used also @Service
// can be used also @Repository
// @Repository, @Service, @Component annotations used for markdown class or object as spring bean.

public class Student {

    private String Name;
    private String Surname;

    private Integer StudentId;

    Student(String name, String surName, Integer studentId){
        this.Name = name;
        this.Surname  = surName;
        this.StudentId = studentId;

    }

    Student(){
        System.out.println("hello world");
    }
    public void setStudentId(Integer studentId) {
        StudentId = studentId;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getStudentId() {
        return StudentId;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }
}
