package com.example.guestbook.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.entity.GuestBook;
import com.example.guestbook.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GuestBookServiceImpl implements GuestBookService {

    private final GuestBookRepository guestBookRepository;

    @Override
    public List<GuestBookDto> getList() {
        // List : java.util.List
        // Sort : org.springframework.data.domain.Sort
        List<GuestBook> list = guestBookRepository.findAll(Sort.by("gno").descending());

        // Function : java.util.function.Function
        Function<GuestBook, GuestBookDto> fn = (entity -> entityToDto(entity));

        // Collectors : java.util.stream.Collectors
        return list.stream().map(fn).collect(Collectors.toList());
    }

    @Override
    public GuestBookDto getRow(Long gno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRow'");
    }

}
