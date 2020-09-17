package com.example.demo.service;

import com.example.demo.entity.BoardGallery;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void register(BoardGallery boardGallery) throws Exception {
        boardRepository.create(boardGallery);
    }

    @Override
    public List<BoardGallery> list() throws Exception{
        return boardRepository.list();
    }

    @Override
    public BoardGallery read(Long boardNo) throws Exception {
        return boardRepository.read(boardNo);
    }

    @Override
    public void remove(Long boardNo) throws Exception {
        boardRepository.remove(boardNo);
    }

    @Override
    public void modify(BoardGallery boardGallery) throws Exception {
        boardRepository.modify(boardGallery);
    }
}
