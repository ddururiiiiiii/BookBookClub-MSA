package com.bookbookclub.common.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 요약 응답 DTO
 */
@Getter
@NoArgsConstructor(force = true)
public class UserSummaryResponse {
    private Long id;
    private String nickname;
    private String profileImageUrl;

    public UserSummaryResponse(Long id, String nickname, String profileImageUrl) {
        this.id = id;
        this.nickname = nickname;
        this.profileImageUrl = profileImageUrl;
    }

    public static UserSummaryResponse of(Long id, String nickname, String profileImageUrl) {
        return new UserSummaryResponse(id, nickname, profileImageUrl);
    }

}
