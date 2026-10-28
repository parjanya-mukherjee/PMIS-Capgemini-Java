package com.parjanya.demo;
public class LooselyCoupledExample {

    public static void main(String[] args) {

        // The dependency is created outside NotificationService.
        MessageSender emailSender = new EmailMessageSender();

        NotificationServiceWithDependencyInjection notificationService =
                new NotificationServiceWithDependencyInjection(emailSender);

        notificationService.sendNotification("Welcome to loose coupling!");

        // The same notification service can use a different implementation.
        MessageSender smsSender = new SmsMessageSender();

        NotificationServiceWithDependencyInjection smsNotificationService =
                new NotificationServiceWithDependencyInjection(smsSender);

        smsNotificationService.sendNotification("This message uses SMS.");
    }
}

/**
 * An interface describes what a sender can do without specifying how it does it.
 */
interface MessageSender {
    void sendMessage(String message);
}

class EmailMessageSender implements MessageSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SmsMessageSender implements MessageSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class NotificationServiceWithDependencyInjection {

    private final MessageSender messageSender;

    public NotificationServiceWithDependencyInjection(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String message) {
        messageSender.sendMessage(message);
    }
}