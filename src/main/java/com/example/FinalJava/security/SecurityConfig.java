package com.example.FinalJava.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET,"/students/students","/students/students/{id}").permitAll()
                        .requestMatchers("/students/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/subjects/subjects","/subjects/subjects/{id}").permitAll()
                        .requestMatchers("/subjects/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/teachers/teachers","/teachers/teachers/{id}").permitAll()
                        .requestMatchers("/teachers/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/universites/universites","/universites/universites/{id}").permitAll()
                        .requestMatchers("/universites/**").hasAnyRole("ADMIN")
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                )

                .httpBasic(basic -> {
                });

        return http.build();
    }

}

