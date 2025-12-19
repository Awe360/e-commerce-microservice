package com.saas.notification_service.notificationDto.request;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Customer{
    private String id;
    private String firstName;
    private String lastName;
    private String email;

}

