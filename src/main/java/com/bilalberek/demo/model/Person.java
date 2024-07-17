package com.bilalberek.demo.model;


import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "person_name",
            length = 40
    )
    private String name;
    @Column(name = "person_age")
    private Integer age;
    @Column(
            name = "person_email",
            unique = true
    )
    private String email;
    @Column(
            updatable = false // registerAt must be immutable field because an entry must have just one date to be registered.
    )
    private Date registerAt;

    public Date getRegisterAt() {
        return registerAt;
    }

    public Person(String name, Integer age, String email, Date registerAt) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.registerAt = registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
    }


    public Person(){

    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

