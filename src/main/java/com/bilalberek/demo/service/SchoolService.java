package com.bilalberek.demo.service;

import com.bilalberek.demo.dto.SchoolDto;
import com.bilalberek.demo.model.School;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.SchoolRepository;
import com.bilalberek.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    SchoolRepository schoolRepository;

    StudentRepository studentRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository, StudentRepository studentRepository){
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }


    public List<SchoolDto> getSchools(){
        return schoolRepository.findAll().stream()
                .map(SchoolDto::toSchoolDto)
                .collect(Collectors.toList());
    }


    public SchoolDto saveSchool(School school){
        School savedSchool = schoolRepository.save(school);
        return SchoolDto.toSchoolDto(savedSchool);
    }


    public ResponseEntity<?> addStudentFromSchool(
            Long schoolId,
            Long studentId
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


    public SchoolDto getSchool(Long schoolId){
        School savedSchool = schoolRepository.findById(schoolId).orElse(new School());
        return SchoolDto.toSchoolDto(savedSchool);
    }
}
