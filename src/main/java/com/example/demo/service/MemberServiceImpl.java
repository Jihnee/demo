package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository repository;

    @Override
    public void register(Member member) throws Exception {
        Member memEntity = new Member();
        memEntity.setUsername(member.getUsername());
        memEntity.setUserid(member.getUserid());
        memEntity.setNickname(member.getNickname());
        memEntity.setFex(member.getFex());
        memEntity.setFartist(member.getFartist());

        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");

        memEntity.addAuth(memberAuth);

        repository.save(memEntity);

        member.setUserid(memEntity.getUserid());

    }

    @Override
    public long countAll() throws Exception {
        return repository.count();
    }
}
