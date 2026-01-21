package com.example.securewebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/h2-console/**").permitAll()
                        .requestMatchers("/notes/**").hasRole("USER")
                        .anyRequest().authenticated()
                )


                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/notes", true)
                        .permitAll()
                )

                // Logout
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .permitAll()
                )


                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )


                .headers(headers -> headers
                        .frameOptions(frame -> frame.disable())
                );

        return http.build();
    }
}
