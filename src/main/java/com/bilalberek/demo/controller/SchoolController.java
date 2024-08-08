package com.bilalberek.demo.controller;

import com.bilalberek.demo.dto.SchoolDto;
import com.bilalberek.demo.model.School;
import com.bilalberek.demo.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/schools")
@RestController
public class SchoolController {

    SchoolService schoolService;

    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @GetMapping("/")
    public List<SchoolDto> getSchools(){
       return schoolService.getSchools();
    }

    @PostMapping("/")
    public SchoolDto saveSchool(@RequestBody School school){
        return schoolService.saveSchool(school);
    }


    @PostMapping("/{school_id}/students/{student_id}")
    public ResponseEntity<?> addStudentFromSchool(
            @PathVariable("school_id") Long schoolId,
            @PathVariable("student_id") Long studentId
    ){
        return schoolService.addStudentFromSchool(schoolId,studentId);
    }

    @GetMapping("/{school_id}")
    SchoolDto getSchool(@PathVariable("school_id") Long schoolId){
        return schoolService.getSchool(schoolId);
    }

}
