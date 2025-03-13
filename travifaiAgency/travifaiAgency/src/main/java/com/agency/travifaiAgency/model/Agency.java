package com.agency.travifaiAgency.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="agencies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agency {
    @Id
    private String id;

    // Basic Business Information

    private String agencyName;
    private String registeredBusinessName;
    private String businessType;
    private String businessRegistrationNumber;
    private String taxIdentificationNumber;
    private int yearOfEstablishment;

    // Contact & Address Details

    private ContactDetails contactDetails;
    private List<String> operatingRegions;

     // Service Offerings

    private ServiceOfferings serviceOfferings;

      // Documentation & Verification

    private Documentation verificationDocuments;
     
      // Payment & Terms

    private PaymentDetails paymentDetails;
    private boolean termsAccepted;

}
