package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.MessageCodeFormatter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Log
@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HomeController {
    @Autowired
    private MemberService service;

    @Autowired
    private MemberAuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/signup",
                   method = RequestMethod.POST,
                    produces = "text/plain;charset=UTF-8")

    public ResponseEntity<String> setupMember(@Validated @RequestBody Member member) throws Exception {
        log.info("setupSignup - member.getUserName(): " + member.getUsername());
        log.info("setupSignup - service.countAll(): " + service.countAll());

        if (service.countAll() < 100) {
            String inputPassword = member.getUserpw();
            member.setUserpw(passwordEncorder.encode(inputPassword));

            service.setupMember(member);

            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        }

        String message = messageSource.getMessage("common.cannotSetupSignup", null, Locale.KOREAN);

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
