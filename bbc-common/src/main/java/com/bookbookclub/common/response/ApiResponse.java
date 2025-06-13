package com.bookbookclub.common.response;


import com.bookbookclub.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * API 응답 포맷을 표준화하는 클래스
 *
 */
@Getter
public class ApiResponse<T> {
    private final boolean success;
    private final String code;
    private final String message;
    private final T data;

    private ApiResponse(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 성공 응답 생성
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, null, null, data);
    }

    /**
     * 성공 응답 생성 (메시지 포함)
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, "200", message, data);
    }

    /**
     * 성공 응답 생성 (메시지만 포함, data 없이)
     */
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, "200", message, null);
    }

    /**
     * 에러 응답 생성 (비즈니스/공통 예외)
     */
    public static <T> ApiResponse<T> error(BaseErrorCode errorCode) {
        return new ApiResponse<>(false, errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 실패 응답 생성 (에러 코드와 동일)
     */
    public static <T> ApiResponse<T> fail(BaseErrorCode errorCode) {
        return error(errorCode); // alias
    }
}
