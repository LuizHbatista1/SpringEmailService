package com.api.emailService.core;

public record EmailRequest(String to , String subject , String body) {
}
