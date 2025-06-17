package com.bookbookclub.common.event;

public record FeedCreatedEvent(
        Long feedId,
        Long userId,
        Long bookId,
        String content
) {}
