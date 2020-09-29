package com.example.demo.repository;

import com.example.demo.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
    public Info findByInfoNo(String infoNo);
}
