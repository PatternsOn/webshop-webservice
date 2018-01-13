package com.patternson.webshopwebservice.config;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Tobias Pettersson 20180110
 */
@Configuration
public class  SpringSecConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder(StrongPasswordEncryptor passwordEncryptor) {
//        PasswordEncoder passwordEncoder = new PasswordEncoder();
//        passwordEncoder.setPasswordEncryptor(passwordEncryptor);
//        return passwordEncoder;
//    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
//                                                               UserDetailsService userDetailsService) {
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
    }
}
