package com.bilalberek.demo.javaadvancedtopics.factorydesignpattern;

import java.util.Optional;

public interface Notification {
    public String sendNotification(String message);
}

class SmsNotification implements Notification{

    @Override
    public String sendNotification(String message) {
        return "SMS notification send with " + message;
    }
}

class EmailNotification implements Notification{

    @Override
    public String sendNotification(String message) {
        return "Email notification send with " + message;
    }
}
class PushNotification implements Notification{

    @Override
    public String sendNotification(String message) {
        return "Push notification send with " + message;
    }
}

