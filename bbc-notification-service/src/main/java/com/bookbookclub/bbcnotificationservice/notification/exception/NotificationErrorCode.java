package com.bookbookclub.bbcnotificationservice.notification.exception;

import com.bookbookclub.common.exception.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 알림 관련 에러 코드 정의
 */
@Getter
@RequiredArgsConstructor
public enum NotificationErrorCode implements BaseErrorCode {

    NOTIFICATION_NOT_FOUND(404, "NOTIFICATION_001", "알림을 찾을 수 없습니다."),
    NOTIFICATION_FORBIDDEN(403, "NOTIFICATION_002", "해당 알림에 접근할 수 없습니다.");

    private final int statusCode;
    private final String code;
    private final String message;
}
