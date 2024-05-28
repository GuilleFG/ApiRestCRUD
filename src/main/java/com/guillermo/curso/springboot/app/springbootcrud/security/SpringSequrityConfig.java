package com.guillermo.curso.springboot.app.springbootcrud.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSequrityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http){
//        return http.authorizeHttpRequests(a)
//    }




}
