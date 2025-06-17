package com.bookbookclub.common.event;

public record LikeCreatedEvent(
        Long feedId,
        Long senderUserId,
        Long receiverUserId
) {}
