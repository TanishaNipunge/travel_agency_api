package com.agency.travifaiAgency.dto;

import java.util.List;

import com.agency.travifaiAgency.model.ContactDetails;
import com.agency.travifaiAgency.model.Documentation;
import com.agency.travifaiAgency.model.PaymentDetails;
import com.agency.travifaiAgency.model.ServiceOfferings;

import io.swagger.v3.oas.annotations.media.Schema;
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
//import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request payload for agency registration")
public class AgencyRegistrationRequest {
    
    @Schema(description = "Name of the agency", example = "Best Travels Pvt Ltd")
    @NotBlank(message = "Agency Name is required")
    private String agencyName;

    @Schema(description = "Registered business name", example = "Best Travels")
    private String registeredBusinessName;

    @Schema(description = "Type of business", example = "Tour Operator")
    @NotBlank(message = "Business type is required")
    private String businessType;

    @Schema(description = "Business Registration Number", example = "BRN12345678")
    @NotBlank(message = "Business Registration Number is required")
    private String businessRegistrationNumber;

    @Schema(description = "Tax Identification Number", example = "TIN87654321")
    private String taxIdentificationNumber;

    @Schema(description = "Year of establishment", example = "2005")
    private int yearOfEstablishment;

    @Schema(description = "Contact details of the agency")
    @Valid
    @NotNull(message = "Contact details are required")
    private ContactDetails contactDetails;

    @Schema(description = "Regions where the agency operates")
    @NotNull(message = "Operating regions must be specified")
    private List<String> operatingRegions;

    @Schema(description = "Service offerings provided by the agency")
    @Valid
    @NotNull(message = "Service offerings must be specified")
    private ServiceOfferings serviceOfferings;

    @Schema(description = "Verification documents required for registration")
    @Valid
    @NotNull(message = "Verification documents are required")
    private Documentation verificationDocuments;

    @Schema(description = "Payment details for the agency")
    @Valid
    @NotNull(message = "Payment details are required")
    private PaymentDetails paymentDetails;

    @Schema(description = "Indicates whether the terms and conditions are accepted", example = "true")
    @AssertTrue(message = "You must accept the terms & conditions")
    private boolean termsAccepted;
}
