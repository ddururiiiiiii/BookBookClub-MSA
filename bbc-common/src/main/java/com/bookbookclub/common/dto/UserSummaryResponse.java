package com.bookbookclub.common.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 요약 응답 DTO
 */
public record UserSummaryResponse(Long id, String nickname, String profileImageUrl) {
}
