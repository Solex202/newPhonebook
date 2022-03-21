package com.africa.semicolon.phoneBook.dtos.response;

import com.africa.semicolon.phoneBook.data.model.Contact;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class FindContactResponse {
    @NonNull
    private String firstName;
    private String lastName;
    @NonNull
    private String mobileNumber;
    private String emailAddress;
    private String office;

    public FindContactResponse(Contact contact){
        firstName = contact.getFirstName();
        lastName = contact.getLastName();
        mobileNumber = contact.getMobileNumber();
        emailAddress = contact.getEmailAddress();
        office = contact.getOffice();
    }

}
