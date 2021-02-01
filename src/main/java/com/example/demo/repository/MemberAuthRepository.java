package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MemberAuthRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Member checkAuth(Long userNo) throws Exception {
        List<Member> results = jdbcTemplate.query(
            "select user_auth_no,user_no, auth from member_auth where user_no = ?",
            new RowMapper<Member>() {
                @Override
                public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Member mAuth = new Member();

                    mAuth.setUserNo(rs.getLong("user_no"));

                    return mAuth;
                }
            }, userNo
        );

        return results.isEmpty() ? null : results.get(0);
    }
}