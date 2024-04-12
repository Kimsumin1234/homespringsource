package com.example.jpa.repository;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Locker;
import com.example.jpa.entity.SportsMember;

@SpringBootTest
public class LockerRepositoryTest {

    @Autowired
    private LockerRepository lockerRepository;

    @Autowired
    private SportsMemberRepository sportsMemberRepository;

    @Test
    public void insertLockerTest() {
        // 부모로 지정한 Locker 먼저 삽입 해준다
        LongStream.rangeClosed(1, 5).forEach(i -> {
            Locker locker = Locker.builder()
                    .name("locker" + i)
                    .build();
            lockerRepository.save(locker);
        });
    }

    @Test
    public void insertSportsMemberTest() {
        LongStream.rangeClosed(1, 5).forEach(i -> {
            SportsMember sportsMember = SportsMember.builder()
                    .name("member" + i)
                    .locker(Locker.builder().id(i).build())
                    .build();
            sportsMemberRepository.save(sportsMember);
        });
    }
}
