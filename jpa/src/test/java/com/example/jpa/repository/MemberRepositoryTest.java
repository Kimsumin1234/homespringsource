package com.example.jpa.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Member;
import com.example.jpa.entity.RoleType;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void createTest() {
        IntStream.rangeClosed(1, 30).forEach(i -> {
            Member member = Member.builder()
                    .id("user" + i)
                    .userName("user" + i)
                    .age(10 + i)
                    .roleType(RoleType.ADMIN)
                    .description("description " + i)
                    .build();
            memberRepository.save(member);
        });
    }
}
