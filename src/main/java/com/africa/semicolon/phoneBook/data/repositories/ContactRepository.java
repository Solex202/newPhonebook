package com.africa.semicolon.phoneBook.data.repositories;

import com.africa.semicolon.phoneBook.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends MongoRepository<Contact,String> {

    Contact findBy (String name);
    Optional<Contact> findContactBy(String lastName);

    Contact findContactByMobileNumber(String mobileNumber);
    List<Contact> findContactByLastName(String name);

    List<Contact> findByFirstName(String name);

    void deleteAll();
}
