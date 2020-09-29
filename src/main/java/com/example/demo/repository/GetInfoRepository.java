package com.example.demo.repository;

import com.example.demo.entity.GetInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetInfoRepository extends JpaRepository<GetInfo, Long> {
    public GetInfo findByGetInfo(String GetInfoNo);
}
