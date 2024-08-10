package com.bilalberek.demo.mapper;

import com.bilalberek.demo.dto.StudentDto;
import com.bilalberek.demo.dto.StudentResponseDto;
import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {


    public  Student toStudent(StudentDto studentDto){
        Student student = new Student();
        School school = new School();

        student.setName(studentDto.name());
        student.setEmail(studentDto.email());
        school.setId(studentDto.schoolId());
        student.setSchool(school);

        return student;
    }


    public  StudentResponseDto toStudentDto(Student student){
        return new StudentResponseDto(
                student.getName(),
                student.getEmail(),
                student.getSchool() != null ? student.getSchool().getId() : null
        );
    }
}
