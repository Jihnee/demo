package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;


public interface MemberService {
    void registerMember(Member member) throws Exception;
    List<Member> list() throws Exception;
    long countAll() throws Exception;
}
