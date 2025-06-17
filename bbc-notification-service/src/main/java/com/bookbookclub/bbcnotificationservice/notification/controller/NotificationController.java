package com.bookbookclub.bbcnotificationservice.notification.controller;

import com.bookbookclub.bbcnotificationservice.global.jwt.JwtUtil;
import com.bookbookclub.bbcnotificationservice.notification.dto.NotificationResponse;
import com.bookbookclub.bbcnotificationservice.notification.entity.Notification;
import com.bookbookclub.bbcnotificationservice.notification.service.NotificationService;
import com.bookbookclub.common.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<ApiResponse<List<NotificationResponse>>> getNotifications(
            @RequestHeader("Authorization") String authorizationHeader
    ) {
        String token = jwtUtil.extractToken(authorizationHeader);
        Long userId = jwtUtil.getUserId(token);

        List<Notification> notifications = notificationService.getMyNotifications(userId);
        List<NotificationResponse> response = notifications.stream()
                .map(NotificationResponse::from)
                .toList();

        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PatchMapping("/{notificationId}/read")
    public ResponseEntity<ApiResponse<Void>> markAsRead(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable Long notificationId
    ) {
        String token = jwtUtil.extractToken(authorizationHeader);
        Long userId = jwtUtil.getUserId(token);
        notificationService.markAsRead(notificationId, userId);
        return ResponseEntity.ok(ApiResponse.success("알림이 읽음 처리되었습니다."));
    }

    @GetMapping("/unread-count")
    public ResponseEntity<ApiResponse<Long>> getUnreadCount(@RequestHeader("Authorization") String header) {
        String token = jwtUtil.extractToken(header);
        Long userId = jwtUtil.getUserId(token);
        long count = notificationService.countUnread(userId);
        return ResponseEntity.ok(ApiResponse.success("읽지 않은 알림 수 조회 성공", count));
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<ApiResponse<Void>> deleteNotification(
            @RequestHeader("Authorization") String authHeader,
            @PathVariable Long notificationId
    ) {
        String token = jwtUtil.extractToken(authHeader);
        Long userId = jwtUtil.getUserId(token);

        notificationService.deleteNotification(notificationId, userId);
        return ResponseEntity.ok(ApiResponse.success("알림 삭제 완료"));
    }

}
