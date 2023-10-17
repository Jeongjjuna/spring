package com.jeongjjuna.todobackend.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthenticationSecurityConfiguration {

    // Filter chain 재정의

    // 1. 모든 요청에 대해 인증을한다.
    // 2. CSRF를 비활성화 한다 -> 세션이 전혀 없도록 하기 위함(세션이 있다면 활성화 해야한다)
    //     -> 상태가 없는 REST API를 만든다.(no session)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1. 모든 요청에 대한 인증 기능 추가
        http.authorizeHttpRequests(
                auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated()
        );

        // 2. 기본인증 추가하기
        http.httpBasic(Customizer.withDefaults());

        // 3. CSRF 비활성화하기 == 세션을 무상태로 만들기
        http.sessionManagement(
                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.csrf(csrf -> csrf.disable());

        http.cors(Customizer.withDefaults());

        return http.build();
    }


}
