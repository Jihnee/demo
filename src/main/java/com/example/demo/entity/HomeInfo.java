package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class HomeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long homeInfoNo;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 5000)
    private String contents;

    @Column(length = 500)
    private String date;

    @Column(length = 500)
    private String writer;

    @Builder
    public HomeInfo(String contents, String title,
                    String date, String writer) {
        this.title = title;
        this.contents = contents;
        this.date = date;
        this.writer = writer;
    }
}
