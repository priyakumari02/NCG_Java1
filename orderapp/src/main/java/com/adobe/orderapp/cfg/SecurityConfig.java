package com.adobe.orderapp.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//HttpSecurity to define our security rules -> Authorization
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws  Exception {
        httpSecurity.authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/api/orders/**").hasRole("ADMIN")
                                .requestMatchers("/api/products/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/").permitAll()
                                .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager users() {
        return new InMemoryUserDetailsManager(
                User.withUsername("anna").password("{noop}secret").authorities("ROLE_USER").build(),
                User.withUsername("roger").password("{noop}secret").authorities("ROLE_USER", "ROLE_ADMIN").build());
    }
}
