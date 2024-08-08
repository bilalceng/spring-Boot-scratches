package com.bilalberek.demo.controller;

import com.bilalberek.demo.model.Student;
import com.bilalberek.demo.model.StudentProfile;
import com.bilalberek.demo.repository.StudentProfileRepository;
import com.bilalberek.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studentProfiles")
public class StudentProfileController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentProfileRepository studentProfileRepository;

    @PostMapping("/{profile_id}/students/{student_id}")
    ResponseEntity<?> addProfileForSpecificStudent(
            @PathVariable("student_id") Long studentId,
            @PathVariable("profile_id") Long profileId
    ){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        StudentProfile studentProfile = studentProfileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("profile not fond"));
        student.setStudentProfile(studentProfile);
        studentProfile.setStudent(student);
        studentRepository.save(student);
        return ResponseEntity.ok( "Profile added to " + " " +student.getName() + " " + "successfully");
    }

    @PostMapping("/")
    public StudentProfile createStudentProfile(
            @RequestBody StudentProfile studentProfile
    ){
         return studentProfileRepository.save(studentProfile);
    }

    @GetMapping("/")
    public List<StudentProfile> getAllStudentProfiles(){
        return studentProfileRepository.findAll();
    }
}
