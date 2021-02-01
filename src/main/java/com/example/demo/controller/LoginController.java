package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.security.AuthUtil;
import com.example.demo.service.MemberAuthService;
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
    private MemberAuthService authService;

    @GetMapping("mminfo")
    public ResponseEntity<Member> getMminfo(@RequestHeader (name="Authorization") String header) throws Exception {
        Long userNo = AuthUtil.getUserNo(header);
        log.info("check userNo: " + userNo);

        Member mmauth = authService.read(userNo);
        log.info("mmauth: " + mmauth );

        return new ResponseEntity<>(mmauth, HttpStatus.OK);
    }
}
