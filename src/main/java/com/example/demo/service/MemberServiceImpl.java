package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberAuthRepository;
import com.example.demo.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 기능수행을 위한 설계도
public class MemberServiceImpl implements MemberService {
    static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository repository;

    @Autowired
    private MemberAuthRepository authRepository;

    @Override
    public void registerMember(Member member) throws Exception {
        Member memEntity = new Member();
        memEntity.setUserId(member.getUserId());
        memEntity.setUserPw(member.getUserPw());
        memEntity.setUserName(member.getUserName());
        memEntity.setFex(member.getFex());
        memEntity.setFartist(member.getFartist());
        memEntity.setUserE(member.getUserE());

        repository.save(memEntity);

        // userNo는 입력값이 아니라 순차적으로 올라가도록 설정 > service countALl
        member.setUserNo(memEntity.getUserNo());

    }

    @Override
    public List<Member> list() throws Exception {
        return authRepository.list();
    }


    // userNo 시퀀스를 위해 추가 설정
    @Override
    public long countAll() throws Exception {
        return repository.count();
    }
}
