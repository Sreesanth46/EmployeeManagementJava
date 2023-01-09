package com.innovaturelabs.employee.service;

public interface EmailSenderService {
    void sendEmail(String toEmail, String subject, String body);
}
