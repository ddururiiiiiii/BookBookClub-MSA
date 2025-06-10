package com.bookbookclub.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorCode implements BaseErrorCode {
    INTERNAL_SERVER_ERROR("GLOBAL_500", "서버 내부 오류"),
    INVALID_INPUT_VALUE("GLOBAL_400", "유효하지 않은 입력"),
    METHOD_NOT_ALLOWED("GLOBAL_405", "허용되지 않은 HTTP 메서드"),
    ACCESS_DENIED("GLOBAL_403", "접근 권한 없음"),
    ENTITY_NOT_FOUND("GLOBAL_404", "엔티티를 찾을 수 없음"),
    INVALID_TYPE_VALUE("GLOBAL_400_TYPE", "유효하지 않은 타입"),
    UNSUPPORTED_MEDIA_TYPE("GLOBAL_415", "지원하지 않는 미디어 타입"),
    TOO_MANY_REQUESTS("GLOBAL_429", "요청이 너무 많음");

    private final String code;
    private final String message;
}
