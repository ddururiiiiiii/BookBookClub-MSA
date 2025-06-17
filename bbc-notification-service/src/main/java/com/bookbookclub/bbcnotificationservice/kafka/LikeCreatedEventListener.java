package com.bookbookclub.bbcnotificationservice.kafka;

import com.bookbookclub.bbcnotificationservice.notification.enums.NotificationType;
import com.bookbookclub.common.event.LikeCreatedEvent;
import com.bookbookclub.bbcnotificationservice.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeCreatedEventListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "like.created", groupId = "notification-group")
    public void handleLikeCreatedEvent(LikeCreatedEvent event) {
        log.info("👍 좋아요 이벤트 수신! feedId={}, senderUserId={}, receiverUserId={}",
                event.feedId(), event.senderUserId(), event.receiverUserId());

        String content = "누군가 회원님의 피드에 좋아요를 눌렀어요!";
        notificationService.saveNotification(event.receiverUserId(), event.feedId(), content, NotificationType.LIKE);
    }
}
