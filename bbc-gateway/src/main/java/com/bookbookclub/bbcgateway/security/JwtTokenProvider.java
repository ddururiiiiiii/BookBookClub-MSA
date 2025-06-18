package com.bookbookclub.bbcgateway.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * JWT 토큰 유효성 검증 및 사용자 ID 추출
 */
@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    /**
     * 시크릿 키를 기반으로 서명용 Key 객체 생성
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); // secretKey는 Base64 인코딩된 문자열이어야 함
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * JWT 유효성 검증
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * JWT에서 userId (subject) 추출
     */
    public Long getUserId(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Long.valueOf(claims.getSubject());
    }
}
