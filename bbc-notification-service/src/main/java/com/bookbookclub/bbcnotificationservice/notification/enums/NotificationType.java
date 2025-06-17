package com.bookbookclub.bbcnotificationservice.notification.enums;

import lombok.Getter;

/**
 * 알림 유형
 */
@Getter
public enum NotificationType {

    FOLLOW("팔로우 알림"),
    LIKE("좋아요 알림"),
    FEED("피드 알림");

    private final String description;

    NotificationType(String description) {
        this.description = description;
    }
}