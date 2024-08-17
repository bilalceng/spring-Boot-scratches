package com.bilalberek.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @Column(unique = true)
    private String email;
    private LocalDateTime registerAt;

    @OneToOne(
            mappedBy = "student"
    )
    @JsonManagedReference
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;

    public void setAge(Integer age) {
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
       this.studentProfile = studentProfile;
        studentProfile.setStudent(this);
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(Long id, String name, Integer age, String email, LocalDateTime registerAt) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.registerAt = registerAt;
        this.id = id;
    }
    public Student( String name, Integer age, String email, LocalDateTime registerAt) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.registerAt = registerAt;

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(LocalDateTime registerAt) {
        this.registerAt = registerAt;
    }
}

