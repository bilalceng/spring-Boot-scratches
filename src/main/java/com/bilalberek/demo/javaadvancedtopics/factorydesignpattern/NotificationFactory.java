package com.bilalberek.demo.javaadvancedtopics.factorydesignpattern;

public class NotificationFactory {
    public Notification createNotification(NotificationType type) {
        if (type == null) {
            return null;
        }

        if (type == NotificationType.EMAIL_TYPE) {
            return new EmailNotification();
        } else if (type == NotificationType.PUSH_TYPE) {
            return new PushNotification();
        } else if (type == NotificationType.SMS_TYPE) {
            return new SmsNotification();
        } else {
            return null;
        }
    }
}
