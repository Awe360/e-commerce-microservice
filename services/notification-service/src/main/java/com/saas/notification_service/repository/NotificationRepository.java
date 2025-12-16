package com.saas.notification_service.repository;

import com.saas.notification_service.model.Notification;
import com.saas.notification_service.notificationDto.request.PaymentConfirmation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification,String> {
}
