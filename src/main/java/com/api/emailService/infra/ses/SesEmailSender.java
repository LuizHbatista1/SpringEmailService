package com.api.emailService.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.api.emailService.adapters.EmailSenderGateway;
import com.api.emailService.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){

        this.amazonSimpleEmailService = amazonSimpleEmailService;

    }

    @Override
    public void sendEmail(String to, String subject, String body) {

        // creation of request
        SendEmailRequest request = new SendEmailRequest()
                .withSource("fa34silva@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))

                );

        // treatment of errors during the creation
        try{

            this.amazonSimpleEmailService.sendEmail(request);

        } catch (AmazonServiceException exception){

            throw new EmailServiceException("Failure ! ");

        }

    }

}
