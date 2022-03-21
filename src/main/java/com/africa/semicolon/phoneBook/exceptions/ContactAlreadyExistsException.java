package com.africa.semicolon.phoneBook.exceptions;

public class ContactAlreadyExistsException  extends RuntimeException {

    public ContactAlreadyExistsException(String message){
        super(message);
    }
}
