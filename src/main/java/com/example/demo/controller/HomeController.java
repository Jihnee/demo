package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class HomeController {

    @GetMapping("/home")
    public String vueIndex() {

        return "home";
    }

}
