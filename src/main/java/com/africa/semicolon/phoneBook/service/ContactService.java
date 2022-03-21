package com.africa.semicolon.phoneBook.service;

import com.africa.semicolon.phoneBook.data.repositories.ContactRepository;
import com.africa.semicolon.phoneBook.dtos.requests.ContactRequest;
import com.africa.semicolon.phoneBook.dtos.response.AddContactResponse;
import com.africa.semicolon.phoneBook.dtos.response.DeleteContactResponse;
import com.africa.semicolon.phoneBook.dtos.response.FindContactResponse;

import java.util.List;


public interface ContactService {
    AddContactResponse saveByFirstNameAndMobileNumber(ContactRequest request);
    AddContactResponse saveByAllParams(ContactRequest request);
    DeleteContactResponse deleteByFirstNameAndMobileNumber(String mobileNumber, String firstName);
    List<FindContactResponse> findContactByName(String name);
    ContactRepository getRepository();
    FindContactResponse findByMobileNumber(String mobileNumber);
    void deleteAll();
}
