package com.bilalberek.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleBasedController {

    @GetMapping("/admin")
    public ResponseEntity<String> adminEndpoint() {
        return  ResponseEntity.ok("welcome admin page");
    }

    @GetMapping("/seller")
    public ResponseEntity<String> sellerEndpoint() {
        return  ResponseEntity.ok("welcome seller page");
    }

    @GetMapping("/customer")
    public ResponseEntity<String> customerEndpoint() {
        return ResponseEntity.ok("welcome customer page");
    }
}
