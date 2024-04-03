package com.example.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "memotbl")
@Entity
public class Memo {

    @Id
    private Long mno;

    @Column(nullable = false, length = 300)
    private String memoText;

}
