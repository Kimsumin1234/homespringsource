package com.example.guestbook.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.guestbook.entity.GuestBook;

@SpringBootTest
public class GuestBookRepositoryTest {

    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    public void insertTest() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            GuestBook guestBook = GuestBook.builder()
                    .title("Guest Title..." + i)
                    .writer("user" + ((i % 10) + 1))
                    .content("테스트 내용입니다")
                    .build();
            guestBookRepository.save(guestBook);
        });
    }
}
