package com.nevexis.bankspring.dto;

public class MessageDTO {
    private String message;

    public MessageDTO(String s) {
        message = s;
    }

    public String getMessage() {
        return message;
    }
}
