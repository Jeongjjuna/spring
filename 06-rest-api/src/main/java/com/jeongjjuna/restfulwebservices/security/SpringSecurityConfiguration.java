package com.jeongjjuna.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    // 시큐리티 필터체인을 전부 재정의 한다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1 . All requests should be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // 2. If a request is not authenticated, a web page is shown
        http.httpBasic(withDefaults());

        // 3. CSRF -> POST, PUT
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
