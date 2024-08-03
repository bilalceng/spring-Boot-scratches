package com.bilalberek.demo.api.restcontrollers;

import com.bilalberek.demo.dto.UserRegistrationDto;
import com.bilalberek.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;
    @PostMapping("/api/register")
    public ResponseEntity<?> registerNewUser(@RequestBody UserRegistrationDto userRegistrationDto){
        try{
            userService.registerNewUser(userRegistrationDto);
            return ResponseEntity.ok(String.format("%s registered successfully", userRegistrationDto.getUsername()));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
