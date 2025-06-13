package com.bookbookclub.common.exception;

/**
 * 모든 에러 코드 Enum이 구현해야 하는 공통 인터페이스
 *
 * - HttpStatus: HTTP 상태 코드 (예: 400, 404, 500 등)
 * - code: 클라이언트/프론트에 전달되는 고유 에러 식별자 (예: G001, U001 등)
 * - message: 사용자에게 보여질 에러 메시지
 *
 * 각 도메인별 에러코드 Enum (예: GlobalErrorCode, EmailVerificationErrorCode 등)에서 구현
 */
public interface BaseErrorCode {

    int getStatusCode();

    String getCode();
    String getMessage();
}
