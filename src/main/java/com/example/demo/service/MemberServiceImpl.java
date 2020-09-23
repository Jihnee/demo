package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Autowired
    private MemberRepository repository;

    @Override
    public void register(Member member) throws Exception {
        Member memEntity = new Member();
        memEntity.setUserId(member.getUserId());
        memEntity.setUserPw(member.getUserPw());
        memEntity.setUserName(member.getUserName());
        memEntity.setFex(member.getFex());
        memEntity.setFartist(member.getFartist());
        memEntity.setUsere(member.getUsere());

        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_MEMBER");

        memEntity.addAuth(memberAuth);

        repository.save(memEntity);

        member.setUserNo(memEntity.getUserNo());

    }

    private Boolean validateDuplicateMember(Member member) {
        if(!(repository.findByUserId(member.getUserId()).isEmpty())){
            return true;
        }
        return false;
    }

    @Override
    public Boolean setupMember(Member member) throws Exception {
        Member memEntity = new Member();
        memEntity.setUserId(member.getUserId());
        memEntity.setUserPw(member.getUserPw());
        memEntity.setUserName(member.getUserName());
        memEntity.setFex(member.getFex());
        memEntity.setFartist(member.getFartist());
        memEntity.setUsere(member.getUsere());


        MemberAuth memberAuth = new MemberAuth();
        memberAuth.setAuth("ROLE_ADMIN");
        Boolean mck = validateDuplicateMember(memEntity);
        if(mck) {
            System.out.println("이미 존재");
            return false;
        }else {
            memEntity.addAuth(memberAuth);
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
            mem.setUsere((String) valArr[6]);

            memberList.add(mem);
        }

        return memberList;
    }


    @Override
    public long countAll() throws Exception {
        return repository.count();
    }
}
