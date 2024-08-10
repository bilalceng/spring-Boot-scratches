package com.bilalberek.demo;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final Map<String, UserDetails> users = new HashMap<>();
    private final Map<String, String> passwordResetTokens = new HashMap<>();
    private final Map<String, String> userEmails = new HashMap<>(); // Map to store user emails

    public MyUserDetailsService() {
        // Mock users with roles and emails
        users.put("customer", new User("customer", "password",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_CUSTOMER"))));
        userEmails.put("customer", "bilalberek8@gmail.com");

        users.put("admin", new User("admin", "password",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
        userEmails.put("admin", "admin@example.com");

        users.put("seller", new User("seller", "password",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_SELLER"))));
        userEmails.put("seller", "seller@example.com");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public UserDetails findUserByUsername(String username) {
        return users.get(username);
    }

    public String getEmailByUsername(String username) {
        return userEmails.get(username);
    }

    public void saveResetToken(String username, String token) {
        passwordResetTokens.put(token, username);
    }

    public String getUsernameFromToken(String token) {
        return passwordResetTokens.get(token);
    }

    public void deleteResetToken(String token) {
        passwordResetTokens.remove(token);
    }
}
