package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;

public interface MemberService {
    public void register(Member member) throws Exception;
    public Boolean setupMember(Member member) throws Exception;
    public List<Member> list() throws Exception;
    public long countAll() throws Exception;
}
