package com.bookbookclub.bbcnotificationservice.notification.exception;

import com.bookbookclub.common.exception.BaseErrorCode;
import com.bookbookclub.common.exception.BusinessException;

/**
 * 알림 관련 비즈니스 예외
 */
public class NotificationException extends BusinessException {
    public NotificationException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
