package com.saas.notification_service.notificationDto.request;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {

}

