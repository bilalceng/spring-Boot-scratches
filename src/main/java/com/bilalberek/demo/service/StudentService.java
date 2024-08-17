package com.bilalberek.demo.service;

import com.bilalberek.demo.dto.StudentDto;
import com.bilalberek.demo.dto.StudentResponseDto;
import com.bilalberek.demo.mapper.StudentMapper;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository ,StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
             StudentDto studentDto
    ){
        Student savedStudent =  studentRepository.save(studentMapper.toStudent(studentDto));
        return studentMapper.toStudentDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents(){
        List<Student>  obtainedStudents = studentRepository.findAll();
        return obtainedStudents
                .stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(
            Long id
    ){
        Student obtainedStudent = studentRepository.findById(id).orElse(new Student());
        return studentMapper.toStudentDto(obtainedStudent);
    }

    public List<StudentResponseDto> findStudentByName(
             String name
    ){
         List<Student> obtainedStudentByName = studentRepository.findAllByNameContainingIgnoreCase(name);
         return obtainedStudentByName
                 .stream()
                 .map(studentMapper::toStudentDto)
                 .collect(Collectors.toList());
    }

    public void deleteStudentById(
         Long id
    ){
        studentRepository.deleteById(id);
    }

}

