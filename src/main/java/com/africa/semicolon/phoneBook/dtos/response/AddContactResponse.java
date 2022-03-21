package com.africa.semicolon.phoneBook.dtos.response;

import lombok.Data;
import lombok.NonNull;

@Data
public class AddContactResponse {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailAddress;
    private String office;
    private String message;
}
