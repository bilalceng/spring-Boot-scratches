package com.bilalberek.demo.dto;

import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;

public record StudentDto(
        String name,
        String email,
        Long schoolId
) {

    public Student toStudent(){
        Student student = new Student();
        School school = new School();

        student.setName(this.name);
        student.setEmail(this.email());
        school.setId(schoolId);
        student.setSchool(school);

        return student;
    }
}
