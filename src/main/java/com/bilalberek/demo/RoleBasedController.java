package com.bilalberek.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleBasedController {

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello, Admin!";
    }

    @GetMapping("/seller")
    public String sellerEndpoint() {
        return "Hello, Seller!";
    }

    @GetMapping("/customer")
    public String customerEndpoint() {
        return "Hello, Customer!";
    }
}
