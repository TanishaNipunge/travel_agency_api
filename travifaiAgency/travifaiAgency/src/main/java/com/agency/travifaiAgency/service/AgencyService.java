package com.agency.travifaiAgency.service;

import com.agency.travifaiAgency.repository.AgencyRepository;
import com.agency.travifaiAgency.dto.AgencyRegistrationRequest;
import com.agency.travifaiAgency.model.Agency;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Tag(name = "Agency Service", description = "Handles business logic for agency registration")
@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Operation(summary = "Registers a new agency", description = "Saves the agency details to the database")
    public void registerAgency(AgencyRegistrationRequest request) {
        Agency agency = new Agency();
        agency.setAgencyName(request.getAgencyName());
        agency.setRegisteredBusinessName(request.getRegisteredBusinessName());
        agency.setBusinessType(request.getBusinessType());
        agency.setBusinessRegistrationNumber(request.getBusinessRegistrationNumber());
        agency.setTaxIdentificationNumber(request.getTaxIdentificationNumber());
        agency.setYearOfEstablishment(request.getYearOfEstablishment());
        agency.setContactDetails(request.getContactDetails());
        agency.setOperatingRegions(request.getOperatingRegions());
        agency.setServiceOfferings(request.getServiceOfferings());
        agency.setVerificationDocuments(request.getVerificationDocuments());
        agency.setPaymentDetails(request.getPaymentDetails());
        agency.setTermsAccepted(request.isTermsAccepted());

        agencyRepository.save(agency);
    }

    @Operation(summary = "Get agency details by name", description = "Fetches an agency by its name")
    public Agency getAgencyByName(String agencyName) {
        return agencyRepository.findByAgencyName(agencyName)
                .orElseThrow(() -> new RuntimeException("Agency not found with name: " + agencyName));
    }

    @Operation(summary = "Get all agencies", description = "Fetches all registered travel agencies")
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    @Operation(summary = "Update an existing agency", description = "Updates the details of an agency")
    public void updateAgency(String agencyName, @Valid AgencyRegistrationRequest request) {
        Agency agency = agencyRepository.findByAgencyName(agencyName)
                .orElseThrow(() -> new RuntimeException("Agency not found with name: " + agencyName));

        agency.setAgencyName(request.getAgencyName());
        agency.setRegisteredBusinessName(request.getRegisteredBusinessName());
        agency.setBusinessType(request.getBusinessType());
        agency.setBusinessRegistrationNumber(request.getBusinessRegistrationNumber());
        agency.setTaxIdentificationNumber(request.getTaxIdentificationNumber());
        agency.setYearOfEstablishment(request.getYearOfEstablishment());
        agency.setContactDetails(request.getContactDetails());
        agency.setOperatingRegions(request.getOperatingRegions());
        agency.setServiceOfferings(request.getServiceOfferings());
        agency.setVerificationDocuments(request.getVerificationDocuments());
        agency.setPaymentDetails(request.getPaymentDetails());
        agency.setTermsAccepted(request.isTermsAccepted());

        agencyRepository.save(agency);
    }

    @Operation(summary = "Delete an agency by name", description = "Deletes an agency by name")
    public void deleteAgency(String agencyName) {
        Agency agency = agencyRepository.findByAgencyName(agencyName)
                .orElseThrow(() -> new RuntimeException("Agency not found with name: " + agencyName));

        agencyRepository.delete(agency);
    }


}
