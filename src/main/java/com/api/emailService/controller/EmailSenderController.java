package com.api.emailService.controller;

import com.api.emailService.application.EmailSenderService;
import com.api.emailService.core.EmailRequest;
import com.api.emailService.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/email") // endpoint used
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController (EmailSenderService emailService){

        this.emailSenderService = emailService;

        //implementation services

    }

    @PostMapping // method POST
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){

        // treatment of errors
        try{

            this.emailSenderService.sendemail(request.to() , request.subject(), request.body());
            return ResponseEntity.ok("sucess!");
        } catch (EmailServiceException ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error!");

        }

    }

}
