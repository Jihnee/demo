package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log
@RequestMapping("/memberlist")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    // 회원 관리용
    @Autowired
    MemberService memberService;

    @GetMapping("")
    public ResponseEntity<List<Member>> mmlist() throws Exception {
        log.info("member List");

        return new ResponseEntity<>(memberService.list(), HttpStatus.OK);
    }
}
