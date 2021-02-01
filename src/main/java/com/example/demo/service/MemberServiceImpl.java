package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
// 기능수행을 위한 설계도
public class MemberServiceImpl implements MemberService {
    static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository repository;

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

    private Boolean validateDuplicateMember(Member member) {
        if(!(repository.findByUserId(member.getUserId()).isEmpty())){
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkId(Member member) throws Exception {
        Member memEntity = new Member();
        memEntity.setUserId(member.getUserId());
        memEntity.setUserPw(member.getUserPw());
        memEntity.setUserName(member.getUserName());
        memEntity.setFex(member.getFex());
        memEntity.setFartist(member.getFartist());
        memEntity.setUserE(member.getUserE());


        Member memberCheck = new Member();
        memberCheck.setUserId(member.getUserId());
        Boolean mck = validateDuplicateMember(memEntity);
        if(mck) {
            System.out.println("이미 존재");
            return false;
        }else {
            memEntity.setUserId(memEntity.getUserId());
            repository.save(memEntity);
            return true;
        }
    }

    @Override
    public List<Member> list() throws Exception {
        List<Object[]> valArrays = repository.listAllMember();
        List<Member> memberList = new ArrayList<Member>();

        for(Object[] valArr : valArrays) {
            Member mem = new Member();

            mem.setUserNo((Long) valArr[0]);
            mem.setUserId((String) valArr[1]);
            mem.setUserPw((String) valArr[2]);
            mem.setUserName((String) valArr[3]);
            mem.setFex((String) valArr[4]);
            mem.setFartist((String) valArr[5]);
            mem.setUserE((String) valArr[6]);

            memberList.add(mem);
        }

        return memberList;
    }

    // userNo 시퀀스를 위해 추가 설정
    @Override
    public long countAll() throws Exception {
        return repository.count();
    }
}
