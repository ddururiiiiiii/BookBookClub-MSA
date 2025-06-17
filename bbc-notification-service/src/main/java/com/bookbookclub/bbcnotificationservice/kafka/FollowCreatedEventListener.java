package com.bookbookclub.bbcnotificationservice.kafka;

import com.bookbookclub.bbcnotificationservice.notification.enums.NotificationType;
import com.bookbookclub.common.event.FollowCreatedEvent;
import com.bookbookclub.bbcnotificationservice.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FollowCreatedEventListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "follow.created", groupId = "notification-group")
    public void handleFollowCreated(FollowCreatedEvent event) {
        log.info("✅ 팔로우 이벤트 수신! from={} to={}", event.senderUserId(), event.receiverUserId());

        String content = "새로운 팔로워가 생겼어요!";
        notificationService.saveNotification(event.receiverUserId(), null, content, NotificationType.FOLLOW);
    }
}
