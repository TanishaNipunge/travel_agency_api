package com.agency.travifaiAgency.service;
import com.agency.travifaiAgency.repository.AgencyRepository;

import lombok.Data;

import org.springframework.stereotype.Service;

import com.agency.travifaiAgency.dto.AgencyRegistrationRequest;
import com.agency.travifaiAgency.model.Agency;


@Service
public class AgencyService {
    
    private final AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository){
        this.agencyRepository=agencyRepository;
    }

    public void registerAgency(AgencyRegistrationRequest request){
         Agency agency = new Agency();

         // Mapping DTO fields to Model
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

        // Save to MongoDB
        agencyRepository.save(agency);
    }
}
       
