package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// 설정 파일임을 명시해줄 필요성이 있다.
@Configuration
public class DBConfig {
    // Spring 프레임워크에서 관리하는 객체를 Bean이라 한다.
    @Bean
    public DataSource dataSource() {
        // JPA를 사용하기 위한 목적으로 설정하는 것들
        // MySQL의 사용자 비번 구동 드라이버 위치등을 지정하면 된다.
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/WWdb?serverTimezone=UTC&useSSL=false"
        );
        dataSource.setUsername("dbuser");
        dataSource.setPassword("1111");
        return dataSource;
    }
}