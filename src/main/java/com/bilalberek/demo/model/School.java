package com.bilalberek.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {

    public void setId(Long id) {
        this.id = id;
    }

    @GeneratedValue
    @Id
    private Long id ;
    private String title;

    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Student> studentList = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public School(){

    }
    public School(String title, List<Student> studentList) {
        this.title = title;
        studentList = studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
        student.setSchool(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        studentList = studentList;
    }
    public Long getId() {
        return id;
    }

}
