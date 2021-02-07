package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberAuthRepository {
    static final Logger log =
            LoggerFactory.getLogger(MemberAuthRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Member checkAuth(Long userNo) throws Exception {
        List<Member> results = jdbcTemplate.query(
            "select user_no from member where user_no = ?",
            new RowMapper<Member>() {
                @Override
                public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Member member = new Member();

                    member.setUserNo(rs.getLong("user_no"));

                    return member;
                }
            }, userNo
        );

        return results.isEmpty() ? null : results.get(0);
    }

    public List<Member> list() throws Exception {
        log.info("authRepository list()");
        List<Member> results = jdbcTemplate.query(
                "select user_no, user_id, user_name, user_pw, fex, fartist, usere" +
                        "where user_no > 0 order by user_no desc",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                        Member mm = new Member();
                        mm.setUserNo(rs.getLong("user_no"));
                        mm.setUserId(rs.getString("user_id"));
                        mm.setUserName(rs.getString("user_name"));
                        mm.setUserPw(rs.getString("user_pw"));
                        mm.setFex(rs.getString("fex"));
                        mm.setFartist(rs.getString("fartist"));
                        mm.setUserE(rs.getString("usere"));

                        return mm;
                    }
                });

        return results;
    }
}