package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.security.AuthUtil;
import com.example.demo.service.MemberAuthService;
import com.example.demo.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private MemberAuthService mmService;

    @GetMapping("mminfo")
    public ResponseEntity<Member> getMminfo(@RequestHeader (name="Authorization") String header) throws Exception {
        Long userNo = AuthUtil.getUserNo(header);
        log.info("check userNo: " + userNo);

        Member member = mmService.read(userNo);
        log.info("check member: " + member );

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
