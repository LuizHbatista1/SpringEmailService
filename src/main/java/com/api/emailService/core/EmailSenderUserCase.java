package com.api.emailService.core;

// contract with this interface , is the high-level from our application
public interface EmailSenderUserCase {

    // method for return the email , contains parts of a normal email
    void sendemail(String to , String subject , String body);

}
