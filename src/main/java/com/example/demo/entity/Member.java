package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@JsonIgnoreProperties
@Getter
@Setter
@ToString
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userid;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 200, nullable = false)
    private String userpw;

    @Column(length = 2000, nullable = false)
    private String Fex;

    @Column(length = 2000, nullable = false)
    private String Fartist;




}
