package com.bilalberek.demo.model;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.List;

public class School {
    @GeneratedValue
    @Id
    private Long id ;
    private String title;

    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    private List<Student> StudentList;


    public String getTitle() {
        return title;
    }

    public School(){

    }
    public School(String title, List<Student> studentList) {
        this.title = title;
        StudentList = studentList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudentList() {
        return StudentList;
    }

    public void setStudentList(List<Student> studentList) {
        StudentList = studentList;
    }

}
