package com.bilalberek.demo;

import com.bilalberek.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyFirstController {

    PersonRepository repository;

    @Autowired
    public MyFirstController(PersonRepository repository){
        this.repository = repository;
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
    @PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public Person saveStudent(
            @RequestBody Person person
    ){
        return repository.save(person);
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
    @GetMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> findAllStudents(){
        return repository.findAll();
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
    @GetMapping("/persons/{student_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person findStudentById(
           @PathVariable("student_id") Long id
    ){
        return repository.findById(id).orElse(new Person());
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
    @GetMapping("/persons/search/{first-name}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> findStudentById(
            @PathVariable("first-name") String name
    ){
        return repository.findAllByNameContaining(name);
    }


    @PostMapping("/persons/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteByIdStudent(
           @PathVariable("user_id") Long id
    ){
        repository.deleteById(id);
    }


}
