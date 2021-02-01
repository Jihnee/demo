package com.example.demo.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

// 암호화를 해제하는 과정
public class AuthUtil {
    // Header 정보를 날릴때 jwt 형식의 데이터를 날려서 식별할 수 있게 하려고 설정
    public static long getUserNo(String header) throws Exception {
        String token = header.substring(7);

        // signingKey는 Jwt를 실행할때 반드시 valid 되어야 하는 시그니처 키
        // JWT_SECRET 안에 데이터를 signingKey로 지정
        byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

        // parsedToken은 아래의 subject까지 포함하여 디코딩된 데이터를 얻음
        Jws<Claims> parsedToken = Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token);

        long subject = Long.parseLong(parsedToken.getBody().getSubject());
        // String > Long 타입 변환 => parseLong

        // subject = userNo
        return subject;
    }
}