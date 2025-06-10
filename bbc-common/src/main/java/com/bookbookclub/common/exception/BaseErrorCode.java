package com.bookbookclub.common.exception;

/**
 * 모든 ErrorCode Enum이 구현해야 할 인터페이스
 */
public interface BaseErrorCode {
    String getCode();
    String getMessage();
}
