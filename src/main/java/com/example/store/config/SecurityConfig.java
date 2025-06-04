package com.example.store.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration @EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/items/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/api/items/add", "/api/items/update/**", "/api/items/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin().and()
            .httpBasic();
        http.csrf().disable();
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("adminpass")
            .roles("ADMIN")
            .build();
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("userpass")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
