package com.bookbookclub.common.event;

/**
 * 팔로우 생성 이벤트 (Kafka 메시지 전송용)
 */
public record FollowCreatedEvent(
        Long senderUserId,    // 팔로우를 건 사람 (A)
        Long receiverUserId   // 팔로우를 받은 사람 (B)
) {}
