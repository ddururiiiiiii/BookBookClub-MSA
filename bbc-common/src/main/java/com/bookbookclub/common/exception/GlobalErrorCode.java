package com.bookbookclub.common.exception;


import lombok.Getter;

/**
 * 시스템 전역에서 사용되는 공통 에러 코드 정의
 *
 * - 각 에러 항목은 HTTP 상태 코드, 에러 코드 문자열, 사용자 메시지를 포함한다.
 * - 도메인에 속하지 않는 일반적인 예외 상황(400, 403, 404, 500 등)에 사용한다.
 * - BusinessException과 GlobalExceptionHandler에서 참조된다.
 */
@Getter
public enum GlobalErrorCode implements BaseErrorCode {

    INVALID_INPUT_VALUE(400, "G001", "잘못된 입력값입니다."),
    INTERNAL_SERVER_ERROR(500, "G002", "서버 내부 오류입니다."),
    ACCESS_DENIED(403, "G003", "접근이 거부되었습니다."),

    NOT_FOUND(404, "G001", "요청한 리소스를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(405, "G002", "지원하지 않는 HTTP 메서드입니다.");


    private final int statusCode;
    private final String code;
    private final String message;

    GlobalErrorCode(int statusCode, String code, String message) {
        this.statusCode = statusCode;
        this.code = code;
        this.message = message;
    }


}

