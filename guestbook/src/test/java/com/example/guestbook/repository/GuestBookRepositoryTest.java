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

    @Test
    public void testList() {
        guestBookRepository.findAll().forEach(guestbook -> System.out.println(guestbook));
    }

    @Test
    public void testRow() {
        System.out.println(guestBookRepository.findById(12L));
    }

    @Test
    public void testUpdate() {
        GuestBook guestBook = guestBookRepository.findById(300L).get();
        guestBook.setTitle("수정한 title 300");
        guestBook.setContent("수정한 내용 입니다");
        System.out.println(guestBookRepository.save(guestBook));
    }

    @Test
    public void testDelete() {
        guestBookRepository.deleteById(4L);
    }
}
