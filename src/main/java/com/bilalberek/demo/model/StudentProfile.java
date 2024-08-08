package com.bilalberek.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class StudentProfile {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentProfile(Long id, String bio, Student student) {
        this.id = id;
        this.bio = bio;
        this.student = student;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String bio;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentProfile(String bio) {
        this.bio = bio;
    }

    public void addProfileToStudent(Student student){
        student.setStudentProfile(this);
    }

    public StudentProfile(){
    }
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
