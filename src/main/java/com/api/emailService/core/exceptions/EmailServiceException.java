package com.api.emailService.core.exceptions;


// this class is responsible for treat errors
public class EmailServiceException extends RuntimeException{

    public EmailServiceException(String message){

        super(message);

    }

    public EmailServiceException(String message , Throwable cause){

        super(message , cause);
    }

}
