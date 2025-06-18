package com.bookbookclub.bbcgateway.filter;

import com.bookbookclub.bbcgateway.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * JWT 인증 필터 - 모든 요청에 대해 토큰 검증
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthFilter implements GlobalFilter, Ordered {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public int getOrder() {
        return -1; // 가장 먼저 실행
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        // 화이트리스트 (인증 제외 경로)
        if (isWhiteList(path)) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return onError(exchange, "Missing or invalid Authorization header", HttpStatus.UNAUTHORIZED);
        }

        String token = authHeader.substring(7);
        if (!jwtTokenProvider.validateToken(token)) {
            return onError(exchange, "Invalid or expired token", HttpStatus.UNAUTHORIZED);
        }

        Long userId = jwtTokenProvider.getUserId(token);
        ServerWebExchange mutatedExchange = exchange.mutate()
                .request(builder -> builder.header("X-USER-ID", userId.toString()))
                .build();

        return chain.filter(mutatedExchange);
    }

    private boolean isWhiteList(String path) {
        return path.startsWith("/api/auth") || path.startsWith("/api/public");
    }

    private Mono<Void> onError(ServerWebExchange exchange, String message, HttpStatus status) {
        log.warn("[JwtAuthFilter] 인증 실패: {}", message);
        exchange.getResponse().setStatusCode(status);
        return exchange.getResponse().setComplete();
    }
}
