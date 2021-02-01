package com.example.demo.service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberAuthRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class MemberAuthService {
    @Autowired
    MemberAuthRepository authRepository;

    public Member read(Long userNo) throws Exception {
        log.info("MemberAuth Service read()");

        return authRepository.checkAuth(userNo);

    }

}
