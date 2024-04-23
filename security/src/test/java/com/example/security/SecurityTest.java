package com.example.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncoder() {
        // 원본 비밀번호
        String password = "1111";

        // encode : 원본 비밀번호 암호화
        String encodePassword = passwordEncoder.encode(password);

        // password : 1111
        // encode password :
        // {bcrypt}$2a$10$WE1/59DoMEOvXqD7bLbA0uad2XiiY.pRgwDUyGC7FCtYVvSr6BVZm
        // {bcrypt} : 암호화 알고리즘이 여러개존재, 여기서는 {bcrypt} 를 사용
        System.out.println("password : " + password + ", encode password : " + encodePassword);

        // matches : 원본 비밀번호와 암호화된 비밀번호의 일치 여부 확인
        // 원본비밀번호 == 암호화된 비밀번호 매칭 = true
        // 암호해석이 불가능 해서 원본비밀번호도 암호화해서 암호화된거끼리 같은지 비교
        System.out.println(passwordEncoder.matches(password, encodePassword));
    }
}
