package com.bookbookclub.bbcnotificationservice.kafka;

import com.bookbookclub.bbcnotificationservice.notification.service.NotificationService;
import com.bookbookclub.common.event.FeedCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCreatedEventListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "feed.created", groupId = "notification-group")
    public void handleFeedCreatedEvent(FeedCreatedEvent event) {
        log.info("✅ 피드 생성 이벤트 수신! feedId={}, userId={}", event.feedId(), event.userId());
        String message = "새로운 피드가 작성되었습니다: " + event.content();
        notificationService.saveNotification(event.userId(), event.feedId(), message);
    }
}