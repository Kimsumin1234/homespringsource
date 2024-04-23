package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity // Spring Secuity 를 활성화하고 웹 보안 설정을 구성
@Configuration // @Controller, @Service 와 같이 목적명시용 + 객체생성
public class SecurityConfig {
    // 접근제한 권한 개념
    // HTTP ERROR 403 : 권한이 없을경우 403 이 뜬다
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 1. 권한 확인 작업 (controller 이 동작하기 전에 이게 먼저 실행된다)
        http.authorizeHttpRequests(authorize -> authorize
                // /, /security/guest, /auth 이경로는 권한 모두 허용
                .requestMatchers("/", "/security/guest", "/auth").permitAll()
                // /security/member 이경로는 ROLE 에 USER 가 있으면 허용
                .requestMatchers("/security/member").hasRole("USER")
                // /security/admin 이경로는 ROLE 에 ADMIN 가 있으면 허용
                .requestMatchers("/security/admin").hasRole("ADMIN"))

                // 2. 인증 처리 작업 (웹은 대부분 로그인 작업이다)
                // .formLogin(Customizer.withDefaults()); : 디폴트 로그인 페이지 보여주기
                .formLogin(login -> login
                        // .usernameParameter("userid") : Authentication 객체 username 속성명 변경
                        // .passwordParameter("pwd") : Authentication 객체 password 속성명 변경
                        // .successForwardUrl("") : 로그인 성공후 이동할 페이지 설정
                        .loginPage("/member/login").permitAll()) // 내가만든 로그인 페이지 보여주기
                .logout(logout -> logout
                        // 로그아웃 후 이동할 페이지 (디폴트는 로그인 페이지)
                        .logoutSuccessUrl("/")
                        // 로그아웃 페이지 설정
                        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")));

        return http.build();
    }

    // 3. 비밀번호 암호화 작업
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
