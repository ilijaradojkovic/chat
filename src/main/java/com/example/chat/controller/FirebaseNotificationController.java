package com.example.chat.controller;

import com.example.chat.entity.request.PushNotificationRequest;
import com.google.firebase.messaging.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/notifications")
public class FirebaseNotificationController {

    @PostMapping
    public ZonedDateTime pushNotification(@RequestBody PushNotificationRequest pushNotificationRequest) throws FirebaseMessagingException, IOException {

        Notification notification=Notification.builder().setBody(pushNotificationRequest.getMessage()).setTitle(pushNotificationRequest.getTitle()).build();

        Message message=Message.builder().setNotification(notification).setTopic(pushNotificationRequest.getTopic()).build();
        FirebaseMessaging.getInstance().send(message);

        return ZonedDateTime.now();
    }
}
