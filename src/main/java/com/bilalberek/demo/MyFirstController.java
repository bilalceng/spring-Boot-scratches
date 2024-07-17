package com.bilalberek.demo;

import com.bilalberek.demo.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyFirstController {


    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public String insertUser(
            @RequestBody Person user
    ){
        return String.format("%s is inserted successfully");
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello(@RequestParam(value = "name", defaultValue = "world") String name){
        return String.format("Hello %s", name);
    }

    @PostMapping("/user-records")
    @ResponseStatus(HttpStatus.CREATED)
    public String insertRecordUser(
            @RequestBody Person user
    ){
        return String.format("%s is inserted successfully");
    }

    @GetMapping("/hi/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
    ){
        return String.format(" hello from path variable %s ", userName);
    }

    /**
     *     @GetMapping("/hi")
     *     public String requestParam(
     *             @RequestParam("user-surname") String surName
     *     ){
     *         return String.format(" hello from path variable %s ",   surName);
     *     }
     *
     *
     */



    
    //http://localhost:8080/hi?user-name=bilal&user-surname=berek
    @GetMapping("/hi")
    public String requestParam(
            @RequestParam("user-name") String userName,
            @RequestParam("user-surname") String surName
    ){
        return String.format(" hello from path variable %s ", userName + " " + surName);
    }


}
