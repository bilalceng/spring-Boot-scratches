package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    EmailService emailService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        // Authenticate the user
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        auth.getAuthorities();

        // Load the user details
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        // Generate the JWT
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthenticationResponse(jwt);
    }

    @PostMapping("/forgot-password")
    public String requestPasswordReset(@RequestParam String username, @RequestParam String email) {
        UserDetails user = userDetailsService.findUserByUsername(username);
        if (user != null) {
            String token = UUID.randomUUID().toString();
            userDetailsService.saveResetToken(username, token);
            emailService.sendPasswordResetEmail(username, token, email);
            return "Password reset link sent to your email.";
        }
        return "User not found.";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        String username = userDetailsService.getUsernameFromToken(token);
        if (username != null) {
            UserDetails user = userDetailsService.findUserByUsername(username);
            if (user != null) {
                System.out.println("Password for " + username + " has been reset.");
                userDetailsService.deleteResetToken(token);
                return "Password has been reset.";
            }
        }
        return "Invalid or expired token.";
    }
}

