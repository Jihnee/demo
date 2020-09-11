package com.example.demo.controller;

import com.example.demo.entity.BoardGallery;
import com.example.demo.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("/getRegister")
    public String getRegister(BoardGallery boardGallery, Model model)
                                        throws Exception {
        log.info("getRegister()");

        return "boardGallery/register";
    }

    @PostMapping("/postRegister")
    public String postRegister(BoardGallery boardGallery, Model model)
                                        throws Exception {
        log.info("postRegister()");

        service.register(boardGallery);

        model.addAttribute("msg","Register Success");

        return "boardGallery/success";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list()");

        model.addAttribute("list",
                            service.list());

        return "boardGallery/list";
    }

    @GetMapping("/read")
    public String read(int boardNo, Model model)
                        throws Exception {
        log.info("read()");

        model.addAttribute(service.read(boardNo));

        return "boardGallery/read";
    }

    @PostMapping("remove")
    public String remove(int boardNo, Model model)
                        throws Exception {

        log.info("remove()");

        service.remove(boardNo);

        model.addAttribute("msg","Success Delete");

        return "boardGallery/success";
    }

    @GetMapping("getModify")
    public String modify(int boardNo, Model model) throws Exception {

        log.info("getModify()");

        model.addAttribute(service.read(boardNo));
        return "boardGallery/modify";
    }

    @PostMapping("/postModify")
    public String modify(BoardGallery boardGallery, Model model) throws Exception {

        log.info("postModify()");

        service.modify(boardGallery);
        model.addAttribute("msg","modify Success");

        return "boardGallery/success";
    }
}
