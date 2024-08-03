package com.bilalberek.demo.api.restcontrollers;

import com.bilalberek.demo.AuthenticationRequest;
import com.bilalberek.demo.AuthenticationResponse;
import com.bilalberek.demo.CustomUserDetailService;
import com.bilalberek.demo.jwtutils.TokenRequest;
import com.bilalberek.demo.jwtutils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/loginWithJwtToken")
    public ResponseEntity<?> loginWithJwtToken(@RequestBody TokenRequest tokenRequest) {
        String token = tokenRequest.getToken();
        if (jwtUtil.validateTokenLoginWith(token)) {
            String username = jwtUtil.extractUsername(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            return ResponseEntity.ok(userDetails.getUsername() + "  is login successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid token");
        }
    }
}
