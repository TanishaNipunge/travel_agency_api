package com.agency.travifaiAgency.dto;

import java.util.List;

import com.agency.travifaiAgency.model.ContactDetails;
import com.agency.travifaiAgency.model.Documentation;
import com.agency.travifaiAgency.model.PaymentDetails;
import com.agency.travifaiAgency.model.ServiceOfferings;

import jakarta.annotation.security.DenyAll;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyRegistrationRequest {
    
    @NotBlank(message = "Agency Name is required")
    private String agencyName;

    private String registeredBusinessName;

    @NotBlank(message = "Business type is required")
    private String businessType;

    @NotBlank(message = "Business Registration Number is required")
    private String businessRegistrationNumber;

    private String taxIdentificationNumber;

    private int yearOfEstablishment;

    @Valid
    @NotNull(message = "Contact details are required")
    private ContactDetails contactDetails;

    @NotNull(message = "Operating regions must be specified")
    private List<String> operatingRegions;

    @Valid
    @NotNull(message = "Service offerings must be specified")
    private ServiceOfferings serviceOfferings;

    @Valid
    @NotNull(message = "Verification documents are required")
    private Documentation verificationDocuments;

    @Valid
    @NotNull(message = "Payment details are required")
    private PaymentDetails paymentDetails;

    @AssertTrue(message = "You must accept the terms & conditions")
    private boolean termsAccepted;
}
