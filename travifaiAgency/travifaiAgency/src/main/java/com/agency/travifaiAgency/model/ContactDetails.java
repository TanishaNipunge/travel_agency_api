package com.agency.travifaiAgency.model;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDetails {
    
    private String ownerName;
    private String designation;
    private String mobileNumber;
    private String landLineNumber;
    private String whatappNumber;
    private String email;
    private String website;
    private List<String> socialMediaHandles;
    private List<String> addresses;
}
