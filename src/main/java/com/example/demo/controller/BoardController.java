package com.example.demo.controller;

import com.example.demo.entity.BoardGallery;
import com.example.demo.service.BoardService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Log
@RestController
@RequestMapping("/boards")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BoardController {
    private static final Logger log =
            LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @GetMapping("")
    public ResponseEntity<List<BoardGallery>> list()
                                        throws Exception {
        log.info("list()");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<BoardGallery> register(
            @Validated @RequestBody BoardGallery boardGallery,
            UriComponentsBuilder uriBuilder) throws Exception {
        log.info("POST register()");

        service.register(boardGallery);

        log.info("register board_gallery.getBoardNo() = " + boardGallery.getBoardNo());

        return new ResponseEntity<>(boardGallery, HttpStatus.OK);
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<BoardGallery> read(
            @PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("read()");

        BoardGallery boardGallery = service.read(boardNo);
        System.out.println("BoardController: " + boardGallery);

        return new ResponseEntity<BoardGallery>(boardGallery, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> remove(@PathVariable("boardNo") Long boardNo) throws Exception {
        log.info("remove");

        service.remove(boardNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<BoardGallery> modify(
            @PathVariable("boardNo") Long boardNo,
            @Validated @RequestBody BoardGallery boardGallery) throws Exception {
        log.info("Put - modify()");
        System.out.println(boardGallery);

        boardGallery.setBoardNo(boardNo);
        service.modify(boardGallery);

        return new ResponseEntity<>(boardGallery, HttpStatus.OK);
    }
}
