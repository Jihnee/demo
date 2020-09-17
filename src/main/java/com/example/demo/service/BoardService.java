package com.example.demo.service;

import com.example.demo.entity.BoardGallery;

import java.util.List;

public interface BoardService {

    public void register(BoardGallery boardGallery) throws Exception;
    public List<BoardGallery> list() throws Exception;
    public BoardGallery read(Long boardNo) throws Exception;
    public void remove(Long boardNo) throws Exception;
    public void modify(BoardGallery boardGallery) throws Exception;
}
