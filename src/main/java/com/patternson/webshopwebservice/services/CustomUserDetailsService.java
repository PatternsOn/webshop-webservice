package com.patternson.webshopwebservice.services;
//
//import com.patternson.webshopwebservice.domain.CustomUserDetails;
//import com.patternson.webshopwebservice.domain.User;
//import com.patternson.webshopwebservice.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> optionalUsers = userRepository.findByEmail(email);
//
//        optionalUsers
//                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//        return optionalUsers
//                .map(CustomUserDetails::new).get();
//    }
//}