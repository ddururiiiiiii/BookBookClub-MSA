package com.bookbookclub.bbcnotificationservice.notification.entity;

import com.bookbookclub.bbcnotificationservice.notification.enums.NotificationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 알림을 받는 유저 ID */
    @Column(nullable = false)
    private Long userId;

    /** 피드 ID (알림 대상) */
    private Long feedId;

    /** 알림 내용 */
    @Column(nullable = false)
    private String content;

    /** 읽음 여부 */
    @Column(name = "is_read", nullable = false)
    private boolean isRead = false;

    /** 알림 유형 */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;

    /** 삭제 여부 */
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    /** 생성일시 */
    private LocalDateTime createdAt;

    public void markAsRead() {
        this.isRead = true;
    }

    public void delete() {
        this.isDeleted = true;
    }

    /**
     * 생성자: 기본적으로 읽지 않은 상태로 생성
     */
    private Notification(Long userId, Long feedId, String content, NotificationType type) {
        this.userId = userId;
        this.feedId = feedId;
        this.content = content;
        this.type = type;
        this.createdAt = LocalDateTime.now();
        this.isRead = false;
    }

    /**
     * 정적 팩토리 메서드
     */
    public static Notification from(Long userId, Long feedId, String content, NotificationType type) {
        return new Notification(userId, feedId, content, type);
    }
}
