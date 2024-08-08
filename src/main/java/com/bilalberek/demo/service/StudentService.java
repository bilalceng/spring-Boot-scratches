package com.bilalberek.demo.service;

import com.bilalberek.demo.dto.StudentDto;
import com.bilalberek.demo.dto.StudentResponseDto;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.SchoolRepository;
import com.bilalberek.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public StudentResponseDto saveStudent(
             StudentDto studentDto
    ){
        Student savedStudent =  studentRepository.save(studentDto.toStudent());
        return StudentResponseDto.toStudentDto(savedStudent);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public Student findStudentById(
            Long id
    ){
        return studentRepository.findById(id).orElse(new Student());
    }

    public List<Student> findStudentByName(
             String name
    ){
        return studentRepository.findAllByNameContainingIgnoreCase(name);
    }

    public void deleteStudentById(
         Long id
    ){
        studentRepository.deleteById(id);
    }

}

