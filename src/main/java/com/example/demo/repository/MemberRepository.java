package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findByUserId(String userid);

    @Query("select m.userNo, m.userName, m.userPw, m.userCPw, m.Fex, m.Fartist, m.userE from Member m")
    public List<Object[]> listAllMember();
}
