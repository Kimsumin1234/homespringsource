package com.example.jpa.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Item;
import com.example.jpa.entity.ItemSellStatus;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void createTest() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Item item = Item.builder()
                    .itemNm("롱패딩" + i)
                    .price(80000 * i)
                    .stockNumber(30)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .build();
            itemRepository.save(item);
        });
    }

    @Test
    public void readTest() {
        // 한개 조회
        System.out.println(itemRepository.findById(7L));
        // 전체조회
        itemRepository.findAll().forEach(item -> System.out.println(item));
    }

    @Test
    public void updateTest() {
        // 1번 방법
        Item item = itemRepository.findById(3L).get();
        item.setItemNm("운동화");
        item.setPrice(33333);
        itemRepository.save(item);

        // 2번 방법
        itemRepository.findById(7L).ifPresent(item2 -> {
            item2.setItemNm("시계");
            item2.setPrice(77777);
            itemRepository.save(item2);
        });

    }

    @Test
    public void deleteTest() {
        // 1번 방법
        Item item = itemRepository.findById(4L).get();
        itemRepository.delete(item);

        // 2번 방법
        itemRepository.deleteById(6L);
    }
}
