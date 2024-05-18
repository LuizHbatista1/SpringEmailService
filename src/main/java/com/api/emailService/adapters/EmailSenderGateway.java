package com.api.emailService.adapters;

public interface EmailSenderGateway {

    /* create the parameters to use in "EmaiLSenderService" */

    void sendEmail(String to , String subject , String body);

}
