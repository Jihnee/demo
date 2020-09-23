package com.example.demo.repository;

import com.example.demo.entity.BoardGallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class BoardRepository {
    static final Logger log =
            LoggerFactory.getLogger(BoardRepository.class);

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(BoardGallery boardGallery) throws Exception {
        log.info("Repository create()");

        String query = "insert into board_gallery(" +
                "title, content, writer) values(?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement(query, new String[] {"boardNo"});
                        ps.setString(1, boardGallery.getTitle());
                        ps.setString(2, boardGallery.getContent());
                        ps.setString(3, boardGallery.getWriter());
                        return ps;
                    }
                }, keyHolder);

        boardGallery.setBoardNo(keyHolder.getKey().longValue());
    }

    public List<BoardGallery> list() throws Exception {
        log.info("Repository list()");

        List<BoardGallery> results = jdbcTemplate.query(
                "select board_no, title, content, " +
                        "writer, reg_date from board_gallery " +
                        "where board_no > 0 order by " +
                        "board_no desc, reg_date desc",

                new RowMapper<BoardGallery>() {
                    @Override
                    public BoardGallery mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BoardGallery boardGallery = new BoardGallery();
                        boardGallery.setBoardNo(rs.getLong("board_no"));
                        boardGallery.setTitle(rs.getString("title"));
                        boardGallery.setContent(rs.getString("content"));
                        boardGallery.setWriter(rs.getString("writer"));
                        boardGallery.setRegDate(rs.getDate("reg_date"));
                        return boardGallery;
                    }
                });
        return results;
    }

    public BoardGallery read(Long boardNo) throws Exception {
        List<BoardGallery> results = jdbcTemplate.query(
                "select board_no, title, content, writer, " +
                        "reg_date from board_gallery where board_no = ?",
                new RowMapper<BoardGallery>() {
                    @Override
                    public BoardGallery mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BoardGallery boardGallery = new BoardGallery();

                        boardGallery.setBoardNo(rs.getLong("board_no"));
                        boardGallery.setTitle(rs.getString("title"));
                        boardGallery.setWriter(rs.getString("writer"));
                        boardGallery.setContent(rs.getString("content"));
                        boardGallery.setRegDate(rs.getDate("reg_date"));

                        System.out.println("BoardRepository: " + boardGallery);

                        return boardGallery;
                    }
                }, boardNo
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public void remove(Long boardNo) throws Exception {
        String query = "delete from board_gallery where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }

    public void modify(BoardGallery boardGallery) throws Exception {
        String query = "update board_gallery set title = ?, content = ? " +
                        "where board_no = ?";

        jdbcTemplate.update(
                query, boardGallery.getTitle(), boardGallery.getContent(), boardGallery.getBoardNo()
        );
    }
}