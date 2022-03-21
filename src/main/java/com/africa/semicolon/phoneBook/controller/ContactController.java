package com.africa.semicolon.phoneBook.controller;

import com.africa.semicolon.phoneBook.dtos.requests.ContactRequest;
import com.africa.semicolon.phoneBook.dtos.response.AddContactResponse;
import com.africa.semicolon.phoneBook.dtos.response.DeleteContactResponse;
import com.africa.semicolon.phoneBook.dtos.response.FindContactResponse;
import com.africa.semicolon.phoneBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/saveContact")
    public AddContactResponse response(@RequestBody ContactRequest request){
        return contactService.saveByFirstNameAndMobileNumber(request);
    }
    @PostMapping("/allParams")
    public AddContactResponse responses(@RequestBody ContactRequest myRequest){
        return contactService.saveByAllParams(myRequest);
    }
    @DeleteMapping("/delete/{mobileNumber}/{firstName}")
    public DeleteContactResponse delete(@PathVariable String mobileNumber, @PathVariable String firstName){
        return contactService.deleteByFirstNameAndMobileNumber(mobileNumber,firstName);
    }

    @GetMapping("/find/{name}")
    public List<FindContactResponse> find(@PathVariable String name){
        return contactService.findContactByName(name);
    }

    @GetMapping("/findBy/{mobile}")
    public FindContactResponse findByMobile(@PathVariable String mobile){
        return  contactService.findByMobileNumber(mobile);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        contactService.deleteAll();
    }
}
