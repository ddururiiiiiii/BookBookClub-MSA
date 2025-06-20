package com.bookbookclub.bbcnotificationservice.notification.repository;

import com.bookbookclub.bbcnotificationservice.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserIdOrderByCreatedAtDesc(Long userId);

    Optional<Notification> findByIdAndUserId(Long id, Long userId);

    long countByUserIdAndIsReadFalse(Long userId);

    List<Notification> findByUserIdAndIsDeletedFalseOrderByCreatedAtDesc();

    Optional<Notification> findByIdAndUserIdAndIsDeletedFalse(Long id, Long userId);
}
