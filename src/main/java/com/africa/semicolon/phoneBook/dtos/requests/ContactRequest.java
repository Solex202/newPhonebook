package com.africa.semicolon.phoneBook.dtos.requests;

import lombok.Data;

@Data
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailAddress;
    private String office;
}
