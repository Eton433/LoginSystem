package com.example.LoginSystem.util;

import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY_STRING = "mysecretkeymysecretkeymysecretkey12"; // 32 字元密鑰
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    public String generateToken(String username) {
        long expirationTime = System.currentTimeMillis() + (1000 * 60 * 60); // 1 小時

        return Jwts.builder()
            .subject(username) // 存入 username
            .expiration(new Date(expirationTime)) // 設定過期時間（這裡改為 expiration()）
            .signWith(SECRET_KEY) // 使用 HMAC-SHA 加密
            .compact(); // 產生 Token
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token);
            return true; 
        } catch (Exception e) {
            return false; 
        }
    }
    
}
