package com.bookbookclub.bbcnotificationservice.notification.dto;

import com.bookbookclub.bbcnotificationservice.notification.entity.Notification;
import com.bookbookclub.bbcnotificationservice.notification.enums.NotificationType;

import java.time.LocalDateTime;

public record NotificationResponse(
        Long id,
        String content,
        boolean isRead,
        LocalDateTime createdAt,
        NotificationType type
) {
    public static NotificationResponse from(Notification notification) {
        return new NotificationResponse(
                notification.getId(),
                notification.getContent(),
                notification.isRead(),
                notification.getCreatedAt(),
                notification.getType()
        );
    }
}
