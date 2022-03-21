package com.africa.semicolon.phoneBook.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Document("Contacts")
public class Contact {
    @Id
    private String id;
    @NonNull
    private String firstName;

    private String lastName;
    @NonNull
    private String mobileNumber;

    private String emailAddress;

    private String office;


}
