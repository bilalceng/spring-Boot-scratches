package com.bilalberek.demo.service;

import com.bilalberek.demo.dto.StudentDto;
import com.bilalberek.demo.dto.StudentResponseDto;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<StudentResponseDto> findAllStudents(){
        List<Student>  obtainedStudents = studentRepository.findAll();
        return obtainedStudents
                .stream()
                .map(StudentResponseDto::toStudentDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(
            Long id
    ){
        Student obtainedStudent = studentRepository.findById(id).orElse(new Student());
        return StudentResponseDto.toStudentDto(obtainedStudent);
    }

    public List<StudentResponseDto> findStudentByName(
             String name
    ){
         List<Student> obtainedStudentByName = studentRepository.findAllByNameContainingIgnoreCase(name);
         return obtainedStudentByName
                 .stream()
                 .map(StudentResponseDto::toStudentDto)
                 .collect(Collectors.toList());
    }

    public void deleteStudentById(
         Long id
    ){
        studentRepository.deleteById(id);
    }

}

