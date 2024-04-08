package com.example.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;

@ToString
@Entity
public class Test {

    @Id
    private Long id;

    private long id2;

    @Column(columnDefinition = "number(8,0)")
    private int id3;

    private Integer id4;

}
