package com.api.emailService.application;

import com.api.emailService.adapters.EmailSenderGateway;
import com.api.emailService.core.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// here implement the core
public class EmailSenderService implements EmailSenderUserCase {

    private final EmailSenderGateway emailSenderGateway; /* in the part of code is need
    to create a gateway for receiver information from adapters layer */

    @Autowired
    public EmailSenderService (EmailSenderGateway emailGateway){

        this.emailSenderGateway = emailGateway;

    }

    @Override
    public void sendemail(String to, String subject, String body) {

        this.emailSenderGateway.sendEmail(to , subject , body);

        /* was implemented above the parameters from interface "EmailSenderGateway" */

    }
}
