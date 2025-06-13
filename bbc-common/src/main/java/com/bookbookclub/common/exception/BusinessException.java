package com.bookbookclub.common.exception;


/**
 * 모든 도메인 비즈니스 예외의 상위 클래스
 *
 * - RuntimeException을 상속하여 스프링의 예외 전파 체계에 맞춤
 * - BaseErrorCode를 포함하여 에러 코드, 상태 코드, 메시지를 추출 가능
 * - GlobalExceptionHandler에서 이 클래스를 기준으로 예외를 처리함
 *
 * 도메인별 예외는 이 클래스를 상속하여 구체화함
 */
public class BusinessException extends RuntimeException {

    private final BaseErrorCode errorCode;

    public BusinessException(BaseErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BaseErrorCode getErrorCode() {
        return errorCode;
    }

    public int getStatusCode() {
        return errorCode.getStatusCode();
    }

    public String getErrorCodeValue() {
        return errorCode.getCode();
    }

    public String getErrorMessage() {
        return errorCode.getMessage();
    }
}