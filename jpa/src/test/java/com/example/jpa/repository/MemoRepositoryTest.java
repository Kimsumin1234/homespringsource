package com.example.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void insertMemo() {
        // 100개 의 메모 입력
        for (int i = 1; i < 101; i++) {
            Memo memo = new Memo();
            memo.setMemoText("memo text " + i);
            memoRepository.save(memo);
        }

    }

    @Test
    public void getMemo() {
        // 특정 아이디 조회
        Optional<Memo> result = memoRepository.findById(7L);

        System.out.println(result.get());
    }

    @Test
    public void getMemoList() {
        // 전체 메모 조회
        List<Memo> result = memoRepository.findAll();

        for (Memo memo : result) {
            System.out.println(memo);
        }
    }

}
