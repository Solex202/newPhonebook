package com.africa.semicolon.phoneBook.service;

import com.africa.semicolon.phoneBook.data.model.Contact;
import com.africa.semicolon.phoneBook.data.repositories.ContactRepository;
import com.africa.semicolon.phoneBook.dtos.requests.ContactRequest;
import com.africa.semicolon.phoneBook.dtos.response.AddContactResponse;
import com.africa.semicolon.phoneBook.dtos.response.DeleteContactResponse;
import com.africa.semicolon.phoneBook.dtos.response.FindContactResponse;
import com.africa.semicolon.phoneBook.exceptions.AddContactFailureException;
import com.africa.semicolon.phoneBook.exceptions.ContactDoesNotExistException;
import com.africa.semicolon.phoneBook.exceptions.SaveContactException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public AddContactResponse saveByFirstNameAndMobileNumber(ContactRequest request) {
        Contact newContact = new Contact(request.getFirstName(), request.getMobileNumber());
//        Contact contact = contactRepository.findContactByMobileNumber(newContact);
        if (mobileNumberExists(newContact.getMobileNumber())) {
//            System.out.println(newContact.getMobileNumber());
            throw new AddContactFailureException("phone number already exist");
        }
//        if(newContact != null) throw new SaveContactException("contact already exist");
        Contact contactToBeSaved = contactRepository.save(newContact);

        AddContactResponse response = new AddContactResponse();
        response.setFirstName(contactToBeSaved.getFirstName());
        response.setMobileNumber(contactToBeSaved.getMobileNumber());
        response.setMessage("contact saved");

        return response;
    }

//    private boolean mobileNumberExists(String mobileNumber) {
//        Contact contact = contactRepository.findContactByMobileNumber(mobileNumber);
//    }

    private boolean mobileNumberExists(String mobileNumber) {
        Contact contact = contactRepository.findContactByMobileNumber(mobileNumber);
        return contact != null;
    }

    @Override
    public AddContactResponse saveByAllParams(ContactRequest request) {
//        Contact newContact = new Contact(request.getFirstName(), request.getLastName(), request.getMobileNumber(), request.getEmailAddress());
        Contact newContact = new Contact(request.getFirstName(),request.getMobileNumber() );
        newContact.setLastName(request.getLastName());
        newContact.setEmailAddress(request.getEmailAddress());
        newContact.setOffice(request.getOffice());
        Contact contactToBeSaved = contactRepository.save(newContact);

        AddContactResponse response = new AddContactResponse();
        response.setFirstName(contactToBeSaved.getFirstName());
        response.setLastName(contactToBeSaved.getLastName());
        response.setMobileNumber(contactToBeSaved.getMobileNumber());
        response.setEmailAddress(contactToBeSaved.getEmailAddress());
        response.setOffice(contactToBeSaved.getOffice());
        response.setMessage("contact saved");
        return response;
    }

    @Override
    public DeleteContactResponse deleteByFirstNameAndMobileNumber(String mobileNumber, String name) {

        List<Contact> newContact = findByFirstNameOrLastName(name);
        newContact.forEach(contact -> {
            if(contact.getMobileNumber().equals(mobileNumber))
        contactRepository.delete(contact);
        });
//        if(newContact.getFirstName().equalsIgnoreCase(name) && newContact.getMobileNumber().equalsIgnoreCase(mobileNumber)){
//            contactRepository.delete(newContact);
//        }
        DeleteContactResponse response = new DeleteContactResponse();
        response.setMessage("contact deleted");
        return response;
    }

    @Override
    public List<FindContactResponse> findContactByName(String name) {
        List<Contact> contacts = findByFirstNameOrLastName(name);
        if(contacts.isEmpty()) throw new SaveContactException(name + "not found");

        List<FindContactResponse> responses = new ArrayList<>();

        contacts.forEach(contact ->{responses.add(new FindContactResponse(contact));
        });
        return responses;

    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    @Override
    public FindContactResponse findByMobileNumber(String mobileNumber) {
        Contact contact = contactRepository.findContactByMobileNumber(mobileNumber);
        if(contact == null) throw new ContactDoesNotExistException(mobileNumber + "does not exist");


        FindContactResponse response = new FindContactResponse();
        response.setMobileNumber(contact.getMobileNumber());
        response.setFirstName(contact.getFirstName());
        response.setLastName(contact.getLastName());
        response.setEmailAddress(contact.getEmailAddress());
        response.setOffice(contact.getOffice());
        return response;
    }

    @Override
    public void deleteAll() {
        contactRepository.deleteAll();
        System.out.println("All contacts successfully deleted");
    }

    private List<Contact> findByFirstNameOrLastName(String name) {
        List<Contact> contacts = new ArrayList<>();
        contacts.addAll(contactRepository.findByFirstName(name));
        contacts.addAll(contactRepository.findContactByLastName(name));
        return contacts;

    }
}
