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

    public MyUserDetailsService() {
        // Mock users with roles
        users.put("customer", new User("customer", "password",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_CUSTOMER"))));

        users.put("admin", new User("admin", "password",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));

        users.put("seller", new User("seller", "password",
                Arrays.asList(new SimpleGrantedAuthority("ROLE_SELLER"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}

