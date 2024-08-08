package com.bilalberek.demo.controller;

import com.bilalberek.demo.dto.SchoolDto;
import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.SchoolRepository;
import com.bilalberek.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/schools")
@RestController
public class SchoolController {
    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public List<SchoolDto> getSchools(){
       return schoolRepository.findAll().stream()
               .map(SchoolDto::toSchoolDto)
               .collect(Collectors.toList());
    }

    @PostMapping("/")
    public School saveSchool(@RequestBody School school){
        return schoolRepository.save(school);
    }


    @PostMapping("/{school_id}/students/{student_id}")
    public ResponseEntity<?> addStudentFromSchool(
            @PathVariable("school_id") Long schoolId,
            @PathVariable("student_id") Long studentId
    ){
        School school = schoolRepository.findById(schoolId).orElseThrow(() -> new RuntimeException("school not found"));
        Student student  = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("student not found"));


        if(school.getStudentList().contains(student)){
          return ResponseEntity.status(HttpStatus.CONFLICT).body( student.getName()
                  + " " + "is already registered");
        }
        else{
            school.addStudent(student);
            schoolRepository.save(school);
            student.setSchool(school);
            return  ResponseEntity.ok(
                    student.getName() +
                            " " + "is registered successfully in" +
                            " " + school.getTitle()
            );
        }
    }

    @GetMapping("/{school_id}")
    School getSchool(@PathVariable("school_id") Long schoolId){
        return schoolRepository.findById(schoolId).orElse(new School());
    }

}
