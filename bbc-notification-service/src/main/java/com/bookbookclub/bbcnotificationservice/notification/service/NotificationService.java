package com.bookbookclub.bbcnotificationservice.notification.service;

import com.bookbookclub.bbcnotificationservice.notification.entity.Notification;
import com.bookbookclub.bbcnotificationservice.notification.enums.NotificationType;
import com.bookbookclub.bbcnotificationservice.notification.exception.NotificationErrorCode;
import com.bookbookclub.bbcnotificationservice.notification.exception.NotificationException;
import com.bookbookclub.bbcnotificationservice.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void saveNotification(Long userId, Long feedId, String content, NotificationType type) {
        Notification notification = Notification.from(userId, feedId, content, type);
        notificationRepository.save(notification);
    }

    @Transactional(readOnly = true)
    public List<Notification> getMyNotifications(Long userId) {
        return notificationRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    @Transactional
    public void markAsRead(Long notificationId, Long userId) {
        Notification notification = notificationRepository.findByIdAndUserIdAndIsDeletedFalse(notificationId, userId)
                .orElseThrow(() -> new NotificationException(NotificationErrorCode.NOTIFICATION_NOT_FOUND));
        notification.markAsRead();
    }

    @Transactional(readOnly = true)
    public long countUnread(Long userId) {
        return notificationRepository.countByUserIdAndIsReadFalse(userId);
    }

    @Transactional
    public void deleteNotification(Long notificationId, Long userId) {
        Notification notification = notificationRepository.findByIdAndUserIdAndIsDeletedFalse(notificationId, userId)
                .orElseThrow(() -> new NotificationException(NotificationErrorCode.NOTIFICATION_NOT_FOUND));
        notification.delete();
    }

}
