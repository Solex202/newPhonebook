package com.africa.semicolon.phoneBook.exceptions;

public class ContactDoesNotExistException extends RuntimeException {
    public ContactDoesNotExistException(String message) {
        super(message);
    }
}
