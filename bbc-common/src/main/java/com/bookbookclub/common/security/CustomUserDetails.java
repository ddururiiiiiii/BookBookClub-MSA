package com.bookbookclub.common.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Collections;

/**
 * JWT에서 인증된 사용자 정보를 담는 UserDetails 구현체
 * MSA 환경에서는 User 엔티티 대신 필요한 정보만 필드로 보관
 */
@Getter
public class CustomUserDetails implements UserDetails {

    private final Long userId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 현재 권한은 사용하지 않음
    }

    @Override
    public String getPassword() {
        return null; // OAuth2 + JWT 기반 인증이므로 비밀번호 없음
    }

    @Override
    public String getUsername() {
        return userId != null ? userId.toString() : "anonymous";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public CustomUserDetails(Long userId) {
        this.userId = userId;
    }

}