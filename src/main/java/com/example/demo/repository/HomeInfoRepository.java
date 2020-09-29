package com.example.demo.repository;

import com.example.demo.entity.HomeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeInfoRepository  extends JpaRepository<HomeInfo, Long> {
}
