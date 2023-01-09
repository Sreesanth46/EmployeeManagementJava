package com.innovaturelabs.manager.service;

/**
 *
 * @author Sreesanth
 */
public interface EmailSenderService {

    void sendEmail(String toEmail, String subject, String body);
}
