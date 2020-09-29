package com.example.demo.service;

import com.example.demo.entity.HomeInfo;
import com.example.demo.entity.Info;
import com.example.demo.repository.GetInfoRepository;
import com.example.demo.repository.HomeInfoRepository;
import com.example.demo.repository.InfoRepository;
import jdk.jfr.Label;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import java.util.List;

@Service
@Lazy
@Log
public class GetInfoService {
    @Autowired
    GetInfoRepository getInfoRepository;

    @Autowired
    HomeInfoRepository homeInfoRepository;

    @Autowired
    InfoRepository infoRepository;

    private Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebkit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                .execute();
            document = (Document) homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    public List<Info> infoFindAll() {
        log.info("infoFindAll()");

        return infoRepository.findAll();
    }

    public List<HomeInfo> homeInfosFindAll() {
        log.info("homeInfoFindAll()");

        return homeInfoRepository.findAll();
    }

}
