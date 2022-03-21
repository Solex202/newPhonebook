package com.africa.semicolon.phoneBook.data.repositories;

import com.africa.semicolon.phoneBook.data.model.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.hamcrest.Matchers.*;
//import static org.hamcrest.CoreMatchers.*;

@DataMongoTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository repository;

    @Test
    public void saveContactTest(){
        Contact contact = new Contact();
        contact.setFirstName("Npo");
        contact.setLastName("no");
        contact.setMobileNumber("75678");
        contact.setOffice("sabo");
        contact.setEmailAddress("rfj3n");

        Contact savedContact = repository.save(contact);
        assertNotNull(savedContact.getId());
        assertEquals(1, repository.count());

        //assertThat(repository.count(), is(1);
    }
}
