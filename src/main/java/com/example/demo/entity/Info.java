package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoSeq;

    @Column(length = 20, nullable = false)
    private String infoNo;

    @Column(length = 20, nullable = false)
    private String category;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String address;

    @Builder
    public Info(String infoNo, String category, String title, String address) {
        this.infoNo = infoNo;
        this.address = address;
        this.category = category;
        this.title = title;
    }
}
