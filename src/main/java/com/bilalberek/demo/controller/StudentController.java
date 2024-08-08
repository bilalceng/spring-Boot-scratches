package com.bilalberek.demo.controller;

import com.bilalberek.demo.dto.StudentDto;
import com.bilalberek.demo.dto.StudentResponseDto;
import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.repository.StudentRepository;
import com.bilalberek.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }



    /**
     *  POST http://localhost:8080/persons
     *
     * body:
     * {
     *    "name":"Bilal",
     *     "age":"26",
     *     "email": "bilal72@gmail.com",
     *     "registerAt": "2024-07-17T12:34:56.789Z"
     * }
     *
     *  response:
     *  {
     *     "id": 9,
     *     "name": "Bilal",
     *     "age": 26,
     *     "email": "bilal72@gmail.com",
     *     "registerAt": "2024-07-17T12:34:56.789+00:00"
     * }
     */
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto studentDto
    ){
        return studentService.saveStudent(studentDto) ;
    }



    /**
     *  GET http://localhost:8080/persons
     *
     *  [
     *     {
     *         "id": 1,
     *         "name": "Bilal",
     *         "age": 26,
     *         "email": "bilal@gmail.com",
     *         "registerAt": "2024-07-17T00:00:00.000+00:00"
     *     },
     *     {
     *         "id": 3,
     *         "name": "Bilal",
     *         "age": 26,
     *         "email": "bilal1@gmail.com",
     *         "registerAt": "2024-07-17T00:00:00.000+00:00"
     *     },
     *     {
     *         "id": 4,
     *         "name": "Bilal",
     *         "age": 26,
     *         "email": "bilal2@gmail.com",
     *         "registerAt": "2024-07-17T00:00:00.000+00:00"
     *     },
     *
     * ]
     */
    @GetMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public List<StudentResponseDto> findAllStudents(){
        return studentService.findAllStudents();
    }



    /**
     * GET http://localhost:8080/persons/1
     *
     * {
     *     "id": 1,
     *     "name": "Bilal",
     *     "age": 26,
     *     "email": "bilal@gmail.com",
     *     "registerAt": "2024-07-17T00:00:00.000+00:00"
     * }
     */
    @GetMapping("/students/{student_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDto findStudentById(
           @PathVariable("student_id") Long id
    ){
        return studentService.findStudentById(id);
    }



    /**
     *GET http://localhost:8080/persons/search/B
     *
     * [
     *     {
     *         "id": 8,
     *         "name": "Bilal",
     *         "age": 26,
     *         "email": "bilal08@gmail.com",
     *         "registerAt": "2024-07-17T12:34:56.789+00:00"
     *     },
     *     {
     *         "id": 9,
     *         "name": "Bilal",
     *         "age": 26,
     *         "email": "bilal09@gmail.com",
     *         "registerAt": "2024-07-17T12:34:56.789+00:00"
     *     },
     *     {
     *         "id": 10,
     *         "name": "Bilal",
     *         "age": 26,
     *         "email": "bilal10@gmail.com",
     *         "registerAt": "2024-07-17T12:34:56.789+00:00"
     *     }
     * ]
     */
    @GetMapping("/students/search/{first-name}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<StudentResponseDto> findStudentByName(
            @PathVariable("first-name") String name
    ){
        return studentService.findStudentByName(name);
    }


    @PostMapping("/students/{student_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
           @PathVariable("student_id") Long id
    ){
        studentService.deleteStudentById(id);
    }

}
